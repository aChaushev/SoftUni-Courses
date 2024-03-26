package exam.service.impl;

import exam.model.dto.ImportTownDTO;
import exam.model.dto.ImportTownRootDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;

        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, IOException {

        ImportTownRootDTO townDTOs = this.xmlParser.fromFile(TOWNS_FILE_PATH, ImportTownRootDTO.class);

        return townDTOs
                .getTowns()
                .stream()
                .map(this::importTown)
                .collect(Collectors.joining("\n"));
    }

    private String importTown(ImportTownDTO dto) {

        Optional<Town> optTown = this.townRepository.findByName(dto.getName()); //NOT IN TASK
        if (!this.validationUtil.isValid(dto) || optTown.isPresent()) {
            return "Invalid town";
        }

        Town town = this.modelMapper.map(dto, Town.class);

        this.townRepository.save(town);

        return String.format("Successfully imported Town %s", dto.getName());
    }
}
