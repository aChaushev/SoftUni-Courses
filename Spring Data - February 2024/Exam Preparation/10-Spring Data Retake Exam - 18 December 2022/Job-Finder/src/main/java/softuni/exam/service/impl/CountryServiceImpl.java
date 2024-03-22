package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    public static final String COUNTRY_FILE_PATH =
            "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;

    private final Gson gson;

    private  final ModelMapper modelMapper;

    private final Validator validator;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        String json = this.readCountriesFileContent();

        ImportCountryDTO[] countryDTOs = this.gson.fromJson(json, ImportCountryDTO[].class);

        return Arrays.stream(countryDTOs)
                .map(this::importCountry)
                .collect(Collectors.joining("\n"));
    }

    private String importCountry(ImportCountryDTO dto) {
        Set<ConstraintViolation<ImportCountryDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid country";
        }

        Optional<Country> optCountry = this.countryRepository.findByNameOrCode(dto.getName(), dto.getCode());


        if(optCountry.isPresent()){
            return "Invalid country";
        }

        Country country = this.modelMapper.map(dto, Country.class);

        this.countryRepository.save(country);

        return String.format("Successfully imported country %s - %s",
                dto.getName(), dto.getCode());
    }
}
