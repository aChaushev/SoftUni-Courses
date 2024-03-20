package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

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
public class AgentServiceImpl implements AgentService {

    private final Path path = Path.of("src", "main", "resources", "files", "json", "agents.json");
    private final AgentRepository agentRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;


    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;

        this.gson = new GsonBuilder().create();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.modelMapper = new ModelMapper();
    }


    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importAgents() throws IOException {
        String json = this.readAgentsFromFile();

        ImportAgentDTO[] agentDTOS = this.gson.fromJson(json, ImportAgentDTO[].class);


        return Arrays.stream(agentDTOS)
                .map(this::importAgent)
                .collect(Collectors.joining("\n"));
    }

    private String importAgent(ImportAgentDTO dto) {
        Set<ConstraintViolation<ImportAgentDTO>> errors =
                this.validator.validate(dto);

        if(!errors.isEmpty()) {
            return "Invalid agent";
        }

        Optional<Agent> optAgentByName = this.agentRepository.findByFirstName(dto.getFirstName());
        Optional<Agent> optAgentByEmail = this.agentRepository.findByEmail(dto.getEmail());

        if(optAgentByName.isPresent() || optAgentByEmail.isPresent()) {
            return "Invalid agent";
        }

        Agent agent = this.modelMapper.map(dto,Agent.class);

        Optional<Town> town = this.townRepository.findByName(dto.getTown());

        agent.setTown(town.get());

        this.agentRepository.save(agent);

        return String.format("Successfully imported agent - %s %s",
                agent.getFirstName(), agent.getLastName());
    }
}
