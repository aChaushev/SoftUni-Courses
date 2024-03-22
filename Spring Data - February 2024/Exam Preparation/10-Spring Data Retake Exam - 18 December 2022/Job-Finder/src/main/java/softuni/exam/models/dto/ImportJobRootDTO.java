package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportJobRootDTO {

    @XmlElement(name = "job")
    private List<ImportJobDTO> jobs;

    public List<ImportJobDTO> getJobs() {
        return jobs;
    }
}
