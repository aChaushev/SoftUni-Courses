package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCompanyDTO;
import softuni.exam.models.dto.ImportCompanyRootDTO;
import softuni.exam.models.entity.Company;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CompanyService;

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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    public static final String COMPANY_FILE_PATH =
            "src/main/resources/files/xml/companies.xml";

    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;

    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, CountryRepository countryRepository, ModelMapper modelMapper) throws JAXBException {
        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;

        JAXBContext context = JAXBContext.newInstance(ImportCompanyRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesFromFile() throws IOException {
        return Files.readString(Path.of(COMPANY_FILE_PATH));
    }

    @Override
    public String importCompanies() throws IOException, JAXBException {
        ImportCompanyRootDTO companyDTOs =
                (ImportCompanyRootDTO) this.unmarshaller.unmarshal(
                        new FileReader(COMPANY_FILE_PATH));

        return companyDTOs
                .getCompanies()
                .stream()
                .map(this::importCompany)
                .collect(Collectors.joining("\n"));

    }

    private String importCompany(ImportCompanyDTO dto) {
        Set<ConstraintViolation<ImportCompanyDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid company";
        }

        Optional<Company> optCompany = this.companyRepository.findByName(dto.getCompanyName());

        if(optCompany.isPresent()) {
            return "Invalid company";
        }

        Optional<Country> country = this.countryRepository.findById(dto.getCountry());

        Company company = this.modelMapper.map(dto, Company.class);

        company.setCountry(country.get());

        //TODO: При записване в базата, когато companyId на вече записана Company e
        // равно на countryId на нова Company -> новата презапизва вече записаната
        this.companyRepository.save(company); /// Проблем при запазването в базата данни
        // id:7 -> "Kunde and Sons" overwrite "Terry and Sons"
        // id:12 -> "Hettinger Inc" overwrite "Kuvalis, Rippin and Klocko"
        //....
        //when companyId of old Entity = countryId of new Entity the old one is overwritten


        return String.format("Successfully imported company %s - %d",
                dto.getCompanyName(),dto.getCountry());
    }
}
