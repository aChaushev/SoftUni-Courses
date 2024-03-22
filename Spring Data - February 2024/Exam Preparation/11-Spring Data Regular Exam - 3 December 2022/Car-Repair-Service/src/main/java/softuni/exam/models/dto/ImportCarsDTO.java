package softuni.exam.models.dto;

import softuni.exam.models.entity.CarType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCarsDTO {

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement
    private String carMake;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement
    private String carModel;

    @NotNull
    @Positive
    @XmlElement
    private int year;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement
    private String plateNumber;

    @NotNull
    @Positive
    @XmlElement
    private int kilometers;

    @NotNull
    @Min(1)
    @XmlElement
    private double engine;

    @NotNull
    @XmlElement
    private CarType carType;

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getYear() {
        return year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public CarType getCarType() {
        return carType;
    }
}
