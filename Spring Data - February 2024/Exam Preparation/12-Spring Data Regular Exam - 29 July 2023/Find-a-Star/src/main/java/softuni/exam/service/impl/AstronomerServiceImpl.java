package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAstronomerDTO;
import softuni.exam.models.dto.ImportAstronomerRootDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;

import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.config.Messages.INVALID_ASTRONOMER;
import static softuni.exam.config.Messages.VALID_ASTRONOMER;
import static softuni.exam.config.Paths.ASTRONOMER_FILE_PATH;


@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;

    private final Unmarshaller unmarshaller;

    //    private final Validator validator;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, Validator validator, ValidationUtil validationUtil, ModelMapper modelMapper) throws JAXBException {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;

        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

        JAXBContext context = JAXBContext.newInstance(ImportAstronomerRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();


    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMER_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        ImportAstronomerRootDTO astronomerDTOs =
                (ImportAstronomerRootDTO) this.unmarshaller.unmarshal(
                        new FileReader(ASTRONOMER_FILE_PATH));

        return astronomerDTOs
                .getAstronomers()
                .stream()
                .map(this::importAstronomer)
                .collect(Collectors.joining("\n"));
    }

    private String importAstronomer(ImportAstronomerDTO dto) {
//        Set<ConstraintViolation<ImportAstronomerDTO>> errors = this.validator.validate(dto);
//
//        if (!errors.isEmpty()) {
//            return INVALID_ASTRONOMER;
//        }

        Optional<Astronomer> optAstronomer = this.astronomerRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        Optional<Star> optStar = this.starRepository.findById(dto.getObservingStarId());

        if (!this.validationUtil.isValid(dto) || optAstronomer.isPresent() || optStar.isEmpty()) {
            return INVALID_ASTRONOMER;
        }

        Astronomer astronomer = this.modelMapper.map(dto, Astronomer.class);

        astronomer.setObservingStar(optStar.get());

        this.astronomerRepository.save(astronomer);

        return String.format(VALID_ASTRONOMER
                , dto.getFirstName(), dto.getLastName(), dto.getAverageObservationHours());
    }
}
