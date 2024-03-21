package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class ImportCountryDTO {

    @Size(min = 2, max = 60)
    private String countryName;

    @Size(min = 2, max = 20)
    private String currency;

    public ImportCountryDTO() {};

    public String getCountryName() {
        return countryName;
    }

    public String getCurrency() {
        return currency;
    }
}
