package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPartDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        String json = this.readPartsFileContent();

        ImportPartDTO[] partDTOs = this.gson.fromJson(json, ImportPartDTO[].class);


        return Arrays.stream(partDTOs)
                .map(this::importPart)
                .collect(Collectors.joining("\n"));
    }

    private String importPart(ImportPartDTO dto) {

        Optional<Part> optParts = this.partsRepository.findByPartName(dto.getPartName());
        if (!this.validationUtil.isValid(dto) || optParts.isPresent()) {
            return "Invalid part";
        }

        Part part = this.modelMapper.map(dto, Part.class);

        this.partsRepository.save(part);


        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.0#", decimalFormatSymbols);
        return String.format("Successfully imported part %s - ", dto.getPartName()) +
                df.format(dto.getPrice());

    }
}
