package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportStarDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.config.Messages.INVALID_STAR;
import static softuni.exam.config.Messages.VALID_STAR;
import static softuni.exam.config.Paths.STAR_FILE_PATH;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;

    private final Gson gson;

    //    private final Validator validator;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, Gson gson, ConstellationRepository constellationRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        String json = this.readStarsFileContent();

        ImportStarDTO[] starDTOs = this.gson.fromJson(json, ImportStarDTO[].class);

        return Arrays.stream(starDTOs)
                .map(this::importStar)
                .collect(Collectors.joining("\n"));
    }

    private String importStar(ImportStarDTO dto) {
//        Set<ConstraintViolation<ImportStarDTO>> errors = this.validator.validate(dto);
//
//        if (!errors.isEmpty()) {
//            return INVALID_STAR;
//        }

        Optional<Star> optStar = this.starRepository.findByName(dto.getName());
        if (!this.validationUtil.isValid(dto) || optStar.isPresent()) {
            return INVALID_STAR;
        }

        Star star = this.modelMapper.map(dto, Star.class);

        Optional<Constellation> constellation = this.constellationRepository.findById(dto.getConstellation());

        star.setConstellation(constellation.get());

        this.starRepository.save(star);

        return String.format(VALID_STAR, dto.getName(), dto.getLightYears());
    }

    @Override
    public String exportStars() {

        List<Star> stars = this.starRepository
                .findStarsByStarTypeAndObserversEmptyOrderByLightYearsAsc(StarType.RED_GIANT);

        return stars
                .stream()
                .map(Star::toString)
                .collect(Collectors.joining("\n"));
    }
}
