package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
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

    private final Path path = Path.of("src", "main", "resources", "files", "json", "countries.json");
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;


        this.gson = new GsonBuilder().create();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(path);
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
        Set<ConstraintViolation<ImportCountryDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid country";
        }

        Optional<Country> optCountry = this.countryRepository.findByCountryName(dto.getCountryName());

        if(optCountry.isPresent()) {
            return "Invalid country";
        }

        Country country = this.modelMapper.map(dto, Country.class);

        this.countryRepository.save(country);

        return String.format("Successfully imported country %s - %s"
                , dto.getCountryName(), dto.getCurrency());
    }
}
