package exam.service.impl;

import exam.model.dto.ImportShopDTO;
import exam.model.dto.ImportShopRootDTO;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;

        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        ImportShopRootDTO shopDTOs = this.xmlParser.fromFile(SHOPS_FILE_PATH, ImportShopRootDTO.class);

        return shopDTOs
                .getShops()
                .stream()
                .map(this::importShop)
                .collect(Collectors.joining("\n"));
    }

    private String importShop(ImportShopDTO dto) {

        Optional<Shop> optShop = this.shopRepository.findByName(dto.getName());
        if(!this.validationUtil.isValid(dto) || optShop.isPresent()) {
            return "Invalid shop";
        }

        Shop shop = this.modelMapper.map(dto, Shop.class);

        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        shop.setTown(town.get());

        this.shopRepository.save(shop);

        return String.format("Successfully imported Shop %s - %d",
                dto.getName(), dto.getIncome().intValue());
    }
}
