package softuni.exam.models.dto;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ImportTownDTO {

    @Size(min = 2)
    private String townName;

    @Positive
    private int population;

    public ImportTownDTO() {
    }

    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }
}
