package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTasksDTO {

    @NotNull
    @XmlElement
    private String date;

    @NotNull
    @Positive
    @XmlElement
    private BigDecimal price;

    @NotNull
    @XmlElement(name = "car")
    private IdDTO car;

    @NotNull
    @XmlElement(name = "mechanic")
    private firstNameDTO mechanic;

    @NotNull
    @XmlElement(name = "part")
    private IdDTO part;

    public String getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public IdDTO getCar() {
        return car;
    }

    public firstNameDTO getMechanic() {
        return mechanic;
    }

    public IdDTO getPart() {
        return part;
    }
}
