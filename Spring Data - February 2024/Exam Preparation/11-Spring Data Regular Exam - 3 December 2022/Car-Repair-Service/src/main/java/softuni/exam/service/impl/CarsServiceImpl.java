package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCarsDTO;
import softuni.exam.models.dto.ImportCarsRootDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;

    private final Unmarshaller unmarshaller;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarsServiceImpl(CarsRepository carsRepository, ValidationUtil validationUtil, ModelMapper modelMapper) throws JAXBException {
        this.carsRepository = carsRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

        JAXBContext context = JAXBContext.newInstance(ImportCarsRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }


    @Override
    public boolean areImported() {
        return this.carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        ImportCarsRootDTO carDTOs =
                (ImportCarsRootDTO) this.unmarshaller.unmarshal(
                new FileReader(CARS_FILE_PATH));

        return carDTOs
                .getCars()
                .stream()
                .map(this::importCar)
                .collect(Collectors.joining("\n"));
    }

    private String importCar(ImportCarsDTO dto) {

        Optional<Car> optCar = this.carsRepository.findByPlateNumber(dto.getPlateNumber());
        if(!this.validationUtil.isValid(dto) || optCar.isPresent()) {
            return "Invalid car";
        }

        Car car = this.modelMapper.map(dto, Car.class);

        this.carsRepository.save(car);

        return String.format("Successfully imported car %s - %s",
                dto.getCarMake(), dto.getCarModel());

    }
}
