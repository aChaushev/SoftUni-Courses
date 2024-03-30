package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportVolcanologistDTO;
import softuni.exam.models.dto.ImportVolcanologistRootDTO;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    private final String VOLANOLOGISTS_FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";

    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;

    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VolcanologistServiceImpl(
            VolcanologistRepository volcanologistRepository,
            VolcanoRepository volcanoRepository, XmlParser xmlParser, ValidationUtil validationUtil,
            ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return Files.readString(Path.of(VOLANOLOGISTS_FILE_PATH));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {

        ImportVolcanologistRootDTO volcanologistDTOs = this.xmlParser.fromFile(VOLANOLOGISTS_FILE_PATH, ImportVolcanologistRootDTO.class);

        return volcanologistDTOs
                .getVolcanologists()
                .stream()
                .map(this::importVolcanologist)
                .collect(Collectors.joining("\n"));
    }

    private String importVolcanologist(ImportVolcanologistDTO dto) {

        Optional<Volcanologist> optVolcanologist =
                this.volcanologistRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        Optional<Volcano> optVolcano = this.volcanoRepository.findById(dto.getVolcanoId());
        if(!this.validationUtil.isValid(dto) ||
            optVolcanologist.isPresent() ||
            optVolcano.isEmpty()) {
            return "Invalid volcanologist";
        }

        Volcanologist volcanologist = this.modelMapper.map(dto, Volcanologist.class);

        volcanologist.setVolcano(optVolcano.get());

        this.volcanologistRepository.save(volcanologist);

        return String.format("Successfully imported volcanologist %s %s",
                dto.getFirstName(), dto.getLastName());
    }
}