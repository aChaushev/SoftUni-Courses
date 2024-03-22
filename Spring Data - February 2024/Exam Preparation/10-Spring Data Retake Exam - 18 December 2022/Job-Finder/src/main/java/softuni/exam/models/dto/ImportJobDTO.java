package softuni.exam.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportJobDTO {

    @NotNull
    @Size(min = 2, max = 40)
    @XmlElement
    private String jobTitle;

    @NotNull
    @Min(10)
    @XmlElement
    private double hoursAWeek;

    @NotNull
    @Min(300)
    @XmlElement
    private double salary;

    @NotNull
    @Size(min = 5)
    @XmlElement
    private String description;

    @XmlElement(name = "companyId")
    private long company;

    public ImportJobDTO() {
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getHoursAWeek() {
        return hoursAWeek;
    }

    public double getSalary() {
        return salary;
    }

    public String getDescription() {
        return description;
    }

    public long getCompany() {
        return company;
    }
}
