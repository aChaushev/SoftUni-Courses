package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTasksDTO;
import softuni.exam.models.dto.ImportTasksRootDTO;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final CarsRepository carsRepository;

    private final Unmarshaller unmarshaller;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TasksServiceImpl(TasksRepository tasksRepository, MechanicsRepository mechanicsRepository, PartsRepository partsRepository, CarsRepository carsRepository, ValidationUtil validationUtil, ModelMapper modelMapper) throws JAXBException {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;

        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

        JAXBContext context = JAXBContext.newInstance(ImportTasksRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        ImportTasksRootDTO taskDTOs =
                (ImportTasksRootDTO) this.unmarshaller.unmarshal(
                        new FileReader(TASKS_FILE_PATH));

        return taskDTOs
                .getTasks()
                .stream()
                .map(this::importTask)
                .collect(Collectors.joining("\n"));
    }

    private String importTask(ImportTasksDTO dto) {

        Optional<Mechanic> mechanic = this.mechanicsRepository.findByFirstName(dto.getMechanic().getFirstName());
        if (!this.validationUtil.isValid(dto) || mechanic.isEmpty()) {
            return "Invalid task";
        }

        Task task = this.modelMapper.map(dto, Task.class);

        Car car = this.carsRepository.getById(dto.getCar().getId());
        Part part = this.partsRepository.getById(dto.getPart().getId());

        task.setCar(car);
        task.setMechanic(mechanic.get());
        task.setPart(part);

        this.tasksRepository.save(task);

        return String.format(Locale.US,"Successfully imported task %.2f",
                dto.getPrice());
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder sb = new StringBuilder();

        List<Task> tasks = this.tasksRepository.findTaskByCar_CarType_CoupeAndOrderByPriceDesc(CarType.coupe);

        tasks
                .forEach(task -> {
                    sb.append(String.format(Locale.US,
                            "Car %s %s with %dkm\n" +
                                    "-Mechanic: %s %s - task №%d:\n" +
                                    " --Engine: %.1f\n" +
                                    "---Price: %.2f$",
                            task.getCar().getCarMake(), task.getCar().getCarModel(), task.getCar().getKilometers(),
                            task.getMechanic().getFirstName(),task.getMechanic().getLastName(),task.getId(),
                            task.getCar().getEngine(),
                            task.getPrice().doubleValue()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
