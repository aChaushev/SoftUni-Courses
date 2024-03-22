package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPersonDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Person;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.PersonService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    public static final String PERSON_FILE_PATH =
            "src/main/resources/files/json/people.json";

    private final PersonRepository personRepository;
    private final CountryRepository countryRepository;

    private final Gson gson;
    private  final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CountryRepository countryRepository, Gson gson, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.countryRepository = countryRepository;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public boolean areImported() {
        return this.personRepository.count() > 0;
    }

    @Override
    public String readPeopleFromFile() throws IOException {
        return Files.readString(Path.of(PERSON_FILE_PATH));
    }

    @Override
    public String importPeople() throws IOException, JAXBException {
        String json = this.readPeopleFromFile();

        ImportPersonDTO[] personDTOs = this.gson.fromJson(json, ImportPersonDTO[].class);

        return Arrays.stream(personDTOs)
                .map(this::importPerson)
                .collect(Collectors.joining("\n"));
    }

    private String importPerson(ImportPersonDTO dto) {
        Set<ConstraintViolation<ImportPersonDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid person";
        }

        Optional<Person> optPerson = this.personRepository.findByFirstNameOrEmailOrPhone(
                dto.getFirstName(), dto.getEmail(), dto.getPhone());
        Optional<Country> optCountry = this.countryRepository.findById(dto.getCountry());

        if(optPerson.isPresent() || optCountry.isEmpty()) {
            return "Invalid person";
        }

        Person person = this.modelMapper.map(dto, Person.class);

        person.setCountry(optCountry.get());

        this.personRepository.save(person);

        return String.format("Successfully imported person %s %s",
                dto.getFirstName(), dto.getLastName());
    }
}
