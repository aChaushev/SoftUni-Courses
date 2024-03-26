package exam.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImportCustomerDTO {

    @NotNull
    @Size(min = 2)
    private String firstName;

    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String registeredOn;

    @NotNull
    private CustomerTownNameDTO town;

    public static class CustomerTownNameDTO {
        private String name;

        public String getName() {
            return name;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public CustomerTownNameDTO getTown() {
        return town;
    }


}
