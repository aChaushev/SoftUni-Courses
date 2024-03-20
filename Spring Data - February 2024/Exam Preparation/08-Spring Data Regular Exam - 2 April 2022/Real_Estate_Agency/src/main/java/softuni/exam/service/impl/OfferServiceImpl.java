package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportOfferDTO;
import softuni.exam.models.dto.ImportOfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final Path path = Path.of("src", "main", "resources", "files", "xml", "offers.xml");

    private final OfferRepository offerRepository;

    private final AgentRepository agentRepository;

    private final ApartmentRepository apartmentRepository;

    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository) throws JAXBException {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;

        JAXBContext context = JAXBContext.newInstance(ImportOfferRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.modelMapper = new ModelMapper();

        this.modelMapper.addConverter(
                ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.class, LocalDate.class);

    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        ImportOfferRootDTO offerDTOs =
                (ImportOfferRootDTO) this.unmarshaller.unmarshal(
                        new FileReader(path.toAbsolutePath().toString()));

        return offerDTOs
                .getOffers()
                .stream()
                .map(this::importOffer)
                .collect(Collectors.joining("\n"));
    }

    private String importOffer(ImportOfferDTO dto) {
        Set<ConstraintViolation<ImportOfferDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid offer";
        }

        Optional<Agent> optAgent = agentRepository.findByFirstName(dto.getAgent().getName());
//        Optional<Offer> optOffer = offerRepository.findByAgent(optAgent);

        if (optAgent.isEmpty()) {
            return "Invalid offer";
        }

        Offer offer = this.modelMapper.map(dto, Offer.class);

        Optional<Agent> agent = this.agentRepository.findByFirstName(dto.getAgent().getName());
        Optional<Apartment> apartment = this.apartmentRepository.findById(dto.getApartment().getId());

        offer.setAgent(agent.get());
        offer.setApartment(apartment.get());

        this.offerRepository.save(offer);

        return String.format("Successfully imported offer %.2f", dto.getPrice());
    }

    @Override
    public String exportOffers() {
        ApartmentType searchedApType = ApartmentType.three_rooms;

        List<Offer> offers = this.offerRepository
                .findAllByApartment_ApartmentTypeOrderByApartmentDescPriceAsc(searchedApType);

        return offers
                .stream()
                .map(Offer::toString)
                .collect(Collectors.joining("\n"));
    }
}
