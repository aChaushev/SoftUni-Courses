package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportConstellationDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.config.Messages.INVALID_CONSTELLATION;
import static softuni.exam.config.Messages.VALID_CONSTELLATION;
import static softuni.exam.config.Paths.CONSTELLATION_FILE_PATH;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private final ConstellationRepository constellationRepository;

    private final Gson gson;

//    private final Validator validator;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.constellationRepository = constellationRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        String json = this.readConstellationsFromFile();

        ImportConstellationDTO[] constellationDTOs = this.gson.fromJson(json, ImportConstellationDTO[].class);

        return Arrays.stream(constellationDTOs)
                .map(this::importConstellation)
                .collect(Collectors.joining("\n"));
    }

    private String importConstellation(ImportConstellationDTO dto) {
//        Set<ConstraintViolation<ImportConstellationDTO>> errors = this.validator.validate(dto);
//
//        if (!errors.isEmpty()) {
//            return INVALID_CONSTELLATION;
//        }

        Optional<Constellation> optConstellation = this.constellationRepository.findByName(dto.getName());
        if (!this.validationUtil.isValid(dto) || optConstellation.isPresent()) {
            return INVALID_CONSTELLATION;
        }

        Constellation constellation = this.modelMapper.map(dto, Constellation.class);

        this.constellationRepository.save(constellation);

        return String.format(VALID_CONSTELLATION,dto.getName(),dto.getDescription());
    }
}
