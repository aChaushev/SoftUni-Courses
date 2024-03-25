package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportAstronomerRootDTO {

    @XmlElement(name = "astronomer")
    private List<ImportAstronomerDTO> astronomers;

    public List<ImportAstronomerDTO> getAstronomers() {
        return astronomers;
    }
}
