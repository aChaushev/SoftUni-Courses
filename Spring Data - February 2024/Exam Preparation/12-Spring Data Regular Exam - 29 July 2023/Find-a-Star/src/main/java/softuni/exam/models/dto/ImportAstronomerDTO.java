package softuni.exam.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportAstronomerDTO {

    @NotNull
    @Min(500)
    @XmlElement(name = "average_observation_hours")
    private double averageObservationHours;


    @XmlElement
    private String birthday;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement(name = "last_name")
    private String lastName;

    @NotNull
    @Min(15000)
    @XmlElement
    private double salary;

    @NotNull
    @XmlElement(name = "observing_star_id")
    private long observingStarId;

    public ImportAstronomerDTO() {
    }

    public double getAverageObservationHours() {
        return averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public long getObservingStarId() {
        return observingStarId;
    }
}
