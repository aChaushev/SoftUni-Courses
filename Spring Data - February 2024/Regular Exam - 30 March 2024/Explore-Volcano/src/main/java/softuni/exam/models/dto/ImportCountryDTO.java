package softuni.exam.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImportCountryDTO {

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @Size(min = 3, max = 30)
    private String capital;

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }
}
