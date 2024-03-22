package softuni.exam.service;



import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CompanyService {

    boolean areImported();

    String readCompaniesFromFile() throws IOException;

    String importCompanies() throws IOException, JAXBException;
}
