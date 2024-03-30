package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "volcanologists")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportVolcanologistRootDTO {

    @XmlElement(name = "volcanologist")
    private List<ImportVolcanologistDTO> volcanologists;

    public List<ImportVolcanologistDTO> getVolcanologists() {
        return volcanologists;
    }
}
