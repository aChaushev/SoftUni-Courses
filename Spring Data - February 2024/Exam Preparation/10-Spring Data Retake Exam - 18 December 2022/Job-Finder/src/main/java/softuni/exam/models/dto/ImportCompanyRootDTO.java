package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompanyRootDTO {

    @XmlElement(name = "company")
    private List<ImportCompanyDTO> companies;

    public List<ImportCompanyDTO> getCompanies() {
        return companies;
    }
}
