package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportLaptopDTO;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        String json = this.readLaptopsFileContent();

        ImportLaptopDTO[] laptopDTOs = this.gson.fromJson(json, ImportLaptopDTO[].class);

        return Arrays.stream(laptopDTOs)
                .map(this::importLaptop)
                .collect(Collectors.joining("\n"));
    }

    private String importLaptop(ImportLaptopDTO dto) {

        Optional<Laptop> optLaptop = this.laptopRepository.findByMacAddress(dto.getMacAddress());
        if(!this.validationUtil.isValid(dto) || optLaptop.isPresent()) {
            return "Invalid Laptop";
        }

        Laptop laptop = this.modelMapper.map(dto, Laptop.class);

        Optional<Shop> shop = this.shopRepository.findByName(dto.getShop().getName());
        laptop.setShop(shop.get());

        this.laptopRepository.save(laptop);

        return String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                dto.getMacAddress(), dto.getCpuSpeed(), dto.getRam(), dto.getStorage());
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        List<Laptop> laptops = this.laptopRepository.getAllOrderByCpuSpeedDescAndRamDescAndStorageDescAndMacAddress();

        laptops
                .forEach(laptop -> {
                    sb.append(String.format(
                                    "Laptop - %s\n" +
                                    "*Cpu speed - %.2f\n" +
                                    "**Ram - %d\n" +
                                    "***Storage - %d\n" +
                                    "****Price - %.2f\n" +
                                    "#Shop name - %s\n" +
                                    "##Town - %s\n",
                                    laptop.getMacAddress(),
                                    laptop.getCpuSpeed(),
                                    laptop.getRam(),
                                    laptop.getStorage(),
                                    laptop.getPrice().doubleValue(),
                                    laptop.getShop().getName(),
                                    laptop.getShop().getTown().getName()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
