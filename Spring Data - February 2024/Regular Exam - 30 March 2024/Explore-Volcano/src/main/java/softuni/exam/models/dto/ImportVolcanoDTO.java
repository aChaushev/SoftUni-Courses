package softuni.exam.models.dto;

import org.springframework.lang.Nullable;
import softuni.exam.models.entity.Country;
import softuni.exam.models.enums.VolcanoType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ImportVolcanoDTO {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Positive
    private int elevation;

    private VolcanoType volcanoType;

    @NotNull
    private boolean isActive;

    private String lastEruption;

    private long country;

    public String getName() {
        return name;
    }

    public int getElevation() {
        return elevation;
    }

    public VolcanoType getVolcanoType() {
        return volcanoType;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getLastEruption() {
        return lastEruption;
    }

    public long getCountry() {
        return country;
    }
}
