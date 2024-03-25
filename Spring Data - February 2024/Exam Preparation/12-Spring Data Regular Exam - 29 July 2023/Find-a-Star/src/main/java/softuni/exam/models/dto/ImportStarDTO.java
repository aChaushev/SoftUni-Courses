package softuni.exam.models.dto;

import softuni.exam.models.entity.StarType;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ImportStarDTO {

    @Size(min = 6)
    private String description;

    @Positive
    private double lightYears;

    @Size(min = 2, max = 30)
    private String name;

    private StarType starType;

    private long constellation;

    public ImportStarDTO() {
    }

    public String getDescription() {
        return description;
    }

    public double getLightYears() {
        return lightYears;
    }

    public String getName() {
        return name;
    }

    public StarType getStarType() {
        return starType;
    }

    public long getConstellation() {
        return constellation;
    }
}
