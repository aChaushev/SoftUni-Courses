package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompanyDTO {

    @NotNull
    @Size(min = 2, max = 40)
    @XmlElement
    private String companyName;

    @NotNull
    @XmlElement
    private String dateEstablished;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement
    private String website;

    @XmlElement(name = "countryId")
    private long country;

    public ImportCompanyDTO() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDateEstablished() {
        return dateEstablished;
    }

    public String getWebsite() {
        return website;
    }

    public long getCountry() {
        return country;
    }
}
