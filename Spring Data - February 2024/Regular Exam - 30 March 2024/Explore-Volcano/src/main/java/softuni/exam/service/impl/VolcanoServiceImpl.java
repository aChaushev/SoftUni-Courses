package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportVolcanoDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolcanoServiceImpl implements VolcanoService {

    private final String VOLCANOES_FILE_PATH = "src/main/resources/files/json/volcanoes.json";

    private final VolcanoRepository volcanoRepository;

    private final CountryRepository countryRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.volcanoRepository = volcanoRepository;
        this.countryRepository = countryRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return Files.readString(Path.of(VOLCANOES_FILE_PATH));
    }

    @Override
    public String importVolcanoes() throws IOException {
        String json = this.readVolcanoesFileContent();

        ImportVolcanoDTO[] volcanoDTOs = this.gson.fromJson(json, ImportVolcanoDTO[].class);

        return Arrays.stream(volcanoDTOs)
                .map(this::importVolcano)
                .collect(Collectors.joining("\n"));
    }

    private String importVolcano(ImportVolcanoDTO dto) {

        Optional<Volcano> optionalVolcano = this.volcanoRepository.findByName(dto.getName());
        if(!this.validationUtil.isValid(dto) || optionalVolcano.isPresent()) {
            return "Invalid volcano";
        }

        Volcano volcano = this.modelMapper.map(dto, Volcano.class);

        Optional<Country> country = this.countryRepository.findById(dto.getCountry());

        volcano.setCountry(country.get());

        this.volcanoRepository.save(volcano);

        return String.format("Successfully imported volcano %s of type %s",
                dto.getName(), dto.getVolcanoType());
    }

    @Override
    public String exportVolcanoes() {

        List<Volcano> volcanoes = this.volcanoRepository.
                findByisActiveIsTrueAndElevationGreaterThanAndLastEruptionNotNullOrderByElevationDesc(3000);

        return volcanoes
                .stream()
                .map(Volcano::toString)
                .collect(Collectors.joining("\n"));
    }
}