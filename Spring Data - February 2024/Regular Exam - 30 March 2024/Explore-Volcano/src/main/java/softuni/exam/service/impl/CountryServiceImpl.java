package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        String json = this.readCountriesFromFile();

        ImportCountryDTO[] countryDTOs = this.gson.fromJson(json, ImportCountryDTO[].class);

        return Arrays.stream(countryDTOs)
                .map(this::importCountry)
                .collect(Collectors.joining("\n"));
    }

    private String importCountry(ImportCountryDTO dto) {

        Optional<Country> optionalCountry = this.countryRepository.findByName(dto.getName());
        if(!this.validationUtil.isValid(dto) || optionalCountry.isPresent()) {
            return "Invalid country";
        }

        Country country = this.modelMapper.map(dto, Country.class);

        this.countryRepository.save(country);

        return String.format("Successfully imported country %s - %s",
                dto.getName(), dto.getCapital());
    }
}
