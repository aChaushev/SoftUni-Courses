package softuni.exam.models.dto;

import softuni.exam.models.entity.DayOfWeek;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ImportForecastDTO {

    @NotNull
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @NotNull
    @XmlElement(name = "max_temperature")
    @Min(-20)
    @Max(60)
    private  double maxTemperature;

    @NotNull
    @XmlElement(name = "min_temperature")
    @Min(-50)
    @Max(40)
    private  double minTemperature;

    @NotNull
    @XmlElement
    private String sunrise;
    @NotNull
    @XmlElement
    private String sunset;

    @XmlElement
    private long city;

    public ImportForecastDTO() {
    }


    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public long getCity() {
        return city;
    }
}
