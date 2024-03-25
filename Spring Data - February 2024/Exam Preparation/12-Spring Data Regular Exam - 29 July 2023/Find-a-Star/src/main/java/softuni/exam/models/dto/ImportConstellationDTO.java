package softuni.exam.models.dto;

import javax.validation.constraints.Size;

public class ImportConstellationDTO {

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 5)
    private String description;

    public ImportConstellationDTO() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
