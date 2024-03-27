package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportUserDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        String json = this.readFromFileContent();

        ImportUserDTO[] userDTOs = this.gson.fromJson(json, ImportUserDTO[].class);

        return Arrays.stream(userDTOs)
                .map(this::importUser)
                .collect(Collectors.joining("\n"));
    }

    private String importUser(ImportUserDTO dto) {

        Optional<User> optUser = this.userRepository.findByUsername(dto.getUsername());
        Optional<Picture> optPicture = this.pictureRepository.findByPath(dto.getProfilePicturePath());
        if(!this.validationUtil.isValid(dto) || optUser.isPresent() || optPicture.isEmpty()) {
            return "Invalid User";
        }

        User user = this.modelMapper.map(dto, User.class);

        user.setProfilePicture(optPicture.get());

        this.userRepository.save(user);

        return String.format("Successfully imported User: %s", dto.getUsername());
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        List<User> users = this.userRepository.getAllUsersOrderByPostsCountDescAndUserIdAsc();

        users
                .forEach(user -> {
                    sb.append(String.format("User: %s\n" +
                            "Post count: %d\n",
                            user.getUsername(),
                            user.getPosts().size()));

                    user.getPosts()
                            .stream()
                            .sorted(Comparator.comparingDouble(p -> p.getPicture().getSize()))
                            .forEach(post -> {
                                sb.append(String.format("==Post Details:\n" +
                                        "----Caption: %s\n" +
                                        "----Picture Size: %.2f\n",
                                        post.getCaption(),
                                        post.getPicture().getSize()));
                            });
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
