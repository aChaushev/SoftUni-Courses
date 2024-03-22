package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportJobDTO;
import softuni.exam.models.dto.ImportJobRootDTO;
import softuni.exam.models.entity.Company;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.repository.JobRepository;
import softuni.exam.service.JobService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    public static final String JOB_FILE_PATH =
            "src/main/resources/files/xml/jobs.xml";

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository, ModelMapper modelMapper) throws JAXBException {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;

        JAXBContext context = JAXBContext.newInstance(ImportJobRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.jobRepository.count() > 0;
    }

    @Override
    public String readJobsFileContent() throws IOException {
        return Files.readString(Path.of(JOB_FILE_PATH));
    }

    @Override
    public String importJobs() throws IOException, JAXBException {
        ImportJobRootDTO jobDTOs =
                (ImportJobRootDTO) this.unmarshaller.unmarshal(
                        new FileReader(JOB_FILE_PATH));

        return jobDTOs
                .getJobs()
                .stream()
                .map(this::importJob)
                .collect(Collectors.joining("\n"));
    }

    private String importJob(ImportJobDTO dto) {
        Set<ConstraintViolation<ImportJobDTO>> errors = validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid job";
        }


        Optional<Company> company = this.companyRepository.findById(dto.getCompany());

        Job job = this.modelMapper.map(dto, Job.class);

        job.setCompany(company.get());

        this.jobRepository.save(job);

        company.get().getJobs().add(job);

        return String.format("Successfully imported job %s", dto.getJobTitle());
    }

    @Override
    public String getBestJobs() {
        StringBuilder sb = new StringBuilder();
        double targetMinSalary = 5000;
        double targetMaxHoursAWeek = 30;

        List<Job> jobs = this.jobRepository.findBySalaryGreaterThanEqualAndHoursAWeekLessThanEqualOrderBySalaryDesc
                (targetMinSalary, targetMaxHoursAWeek);


            jobs
                .forEach(job -> {
                    sb.append(String.format(
                                    "Job title %s\n" +
                                    "-Salary: %.2f$\n" +
                                    "--Hours a week: %.2fh.\n",
                                    job.getTitle(),
                                    job.getSalary(),
                                    job.getHoursAWeek()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
