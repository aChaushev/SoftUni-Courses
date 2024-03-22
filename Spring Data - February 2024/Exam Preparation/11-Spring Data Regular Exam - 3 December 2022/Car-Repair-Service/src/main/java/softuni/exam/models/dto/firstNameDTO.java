package softuni.exam.models.dto;

import org.springframework.data.annotation.AccessType;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

@AccessType(AccessType.Type.FIELD)
public class firstNameDTO {

    @NotNull
    @XmlElement
    private String firstName;

    public String getFirstName() {
        return firstName;
    }
}
