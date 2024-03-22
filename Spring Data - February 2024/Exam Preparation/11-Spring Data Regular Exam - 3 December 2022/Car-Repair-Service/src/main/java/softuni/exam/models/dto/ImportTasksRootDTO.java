package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTasksRootDTO {

    @XmlElement(name = "task")
    List<ImportTasksDTO> tasks;

    public List<ImportTasksDTO> getTasks() {
        return tasks;
    }
}
