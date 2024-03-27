package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportPostDTO;
import softuni.exam.instagraphlite.models.dto.ImportPostRootDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, PictureRepository pictureRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        ImportPostRootDTO postDTOs = this.xmlParser.fromFile(POST_FILE_PATH, ImportPostRootDTO.class);

        return postDTOs
                .getPosts()
                .stream()
                .map(this::importPost)
                .collect(Collectors.joining("\n"));
    }

    private String importPost(ImportPostDTO dto) {

        Optional<User> optUser = this.userRepository.findByUsername(dto.getUser().getUsername());
        Optional<Picture> optPicture = this.pictureRepository.findByPath(dto.getPicture().getPath());
        if (!this.validationUtil.isValid(dto) || optUser.isEmpty() || optPicture.isEmpty()) {
            return "Invalid Post";
        }

        Post post = this.modelMapper.map(dto, Post.class);

        post.setUser(optUser.get());
        post.setPicture(optPicture.get());

        this.postRepository.save(post);

        return String.format("Successfully imported Post, made by %s",dto.getUser().getUsername());
    }
}
