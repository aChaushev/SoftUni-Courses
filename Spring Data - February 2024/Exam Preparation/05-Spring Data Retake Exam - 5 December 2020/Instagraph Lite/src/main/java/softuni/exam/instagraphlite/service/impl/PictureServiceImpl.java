package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportPictureDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        String json = this.readFromFileContent();

        ImportPictureDTO[] pictureDTOs = this.gson.fromJson(json, ImportPictureDTO[].class);

        return Arrays.stream(pictureDTOs)
                .map(this::importPicture)
                .collect(Collectors.joining("\n"));
    }

    private String importPicture(ImportPictureDTO dto) {

        Optional<Picture> optPicture = this.pictureRepository.findByPath(dto.getPath());
        if(!this.validationUtil.isValid(dto) || optPicture.isPresent()) {
            return "Invalid Picture";
        }

        Picture picture = this.modelMapper.map(dto, Picture.class);

        this.pictureRepository.save(picture);

        return String.format("Successfully imported Picture, with size %.2f", dto.getSize());
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        List<Picture> pictures = this.pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000);

        pictures
                .forEach(picture -> {
                    sb.append(String.format("%.2f - %s\n", picture.getSize(), picture.getPath()));
                });

        return sb.toString().trim();
    }
}
