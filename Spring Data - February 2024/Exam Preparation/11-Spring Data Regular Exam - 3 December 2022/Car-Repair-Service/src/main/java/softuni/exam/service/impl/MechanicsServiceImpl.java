package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportMechanicDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MechanicsServiceImpl implements MechanicsService {

    private static String MECHANIC_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicsRepository mechanicsRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.mechanicsRepository = mechanicsRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANIC_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        String json = this.readMechanicsFromFile();

        ImportMechanicDTO[] mechanicDTOs = this.gson.fromJson(json, ImportMechanicDTO[].class);

        return Arrays.stream(mechanicDTOs)
                .map(this::importMechanic)
                .collect(Collectors.joining("\n"));
    }

    private String importMechanic(ImportMechanicDTO dto) {

        Optional<Mechanic> optMechanic = this.mechanicsRepository.findByEmail(dto.getEmail());
        if(!this.validationUtil.isValid(dto) || optMechanic.isPresent()) {
            return  "Invalid mechanic";
        }

        Mechanic mechanic = this.modelMapper.map(dto, Mechanic.class);

        this.mechanicsRepository.save(mechanic);

        return String.format("Successfully imported mechanic %s %s",
                dto.getFirstName(), dto.getLastName());
    }
}
