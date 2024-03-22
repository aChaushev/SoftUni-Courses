package softuni.exam.models.dto;

import org.springframework.data.annotation.AccessType;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

@AccessType(AccessType.Type.FIELD)
public class IdDTO {
    @NotNull
    @XmlElement
    private long id;

    public long getId() {
        return id;
    }
}
