package softuni.exam.models.dto;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportVolcanologistDTO {

    @NotNull
    @Size(min = 2,max = 30)
    @XmlElement(name = "first_name")
    private  String firstName;

    @NotNull
    @Size(min = 2,max = 30)
    @XmlElement(name = "last_name")
    private  String lastName;

    @NotNull
    @Positive
    @XmlElement
    private double salary;

    @NotNull
    @Min(18)
    @Max(80)
    @XmlElement
    private int age;

    @XmlElement(name = "exploring_from")
    private String exploringFrom;

    @XmlElement(name = "exploring_volcano_id")
    private long volcanoId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getExploringFrom() {
        return exploringFrom;
    }

    public long getVolcanoId() {
        return volcanoId;
    }
}
