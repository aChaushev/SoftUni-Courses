package softuni.exam.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImportCountryDTO {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Size(min = 2, max = 19)
    private String countryCode;

    @NotNull
    @Size(min = 2, max = 19)
    private String currency;

    public ImportCountryDTO() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return countryCode;
    }

    public String getCurrency() {
        return currency;
    }
}
