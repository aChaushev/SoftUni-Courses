package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportCustomerDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        String json = this.readCustomersFileContent();

        ImportCustomerDTO[] customerDTOs = this.gson.fromJson(json, ImportCustomerDTO[].class);

        return Arrays.stream(customerDTOs)
                .map(this::importCustomer)
                .collect(Collectors.joining("\n"));
    }

    private String importCustomer(ImportCustomerDTO dto) {

        Optional<Customer> optCustomer = this.customerRepository.findByEmail(dto.getEmail());
        if (!this.validationUtil.isValid(dto) || optCustomer.isPresent()) {
            return "Invalid Customer";
        }

        Customer customer = this.modelMapper.map(dto, Customer.class);

        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        customer.setTown(town.get());

        this.customerRepository.save(customer);

        return String.format("Successfully imported Customer %s %s - %s",
                dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
