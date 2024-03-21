package softuni.exam.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface CityService {

    boolean areImported();

    String readCitiesFileContent() throws IOException;
	
	String importCities() throws IOException;
}
