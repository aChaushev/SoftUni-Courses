package softuni.exam.models.dto;

import softuni.exam.models.entity.ApartmentType;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportApartmentDTO {

    //<apartments>
    //    <apartment>
    //        <apartmentType>three_rooms</apartmentType>
    //        <area>53.47</area>
    //        <town>Lille</town>
    //    </apartment>

    @XmlElement
    private ApartmentType apartmentType;

    @XmlElement
    @Min(40)
    private double area;

    @XmlElement(name = "town")
    private String townName;

    public ImportApartmentDTO() {
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public double getArea() {
        return area;
    }

    public String getTownName() {
        return townName;
    }
}
