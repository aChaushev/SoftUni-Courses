package exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {

                LocalDate parse = LocalDate
                        .parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                return parse;
            }
        });

        return modelMapper;
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
