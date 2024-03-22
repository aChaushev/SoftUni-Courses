package softuni.exam.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public interface PersonService {

    boolean areImported();

    String readPeopleFromFile() throws IOException;

    String importPeople() throws IOException, JAXBException;
}
