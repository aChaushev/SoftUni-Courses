package softuni.exam.areImported;
//TestVolcanoServiceAreImportedTrue

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.impl.VolcanoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestVolcanoServiceAreImportedTrue {

    @InjectMocks
    private VolcanoServiceImpl volcanoService;
    @Mock
    private VolcanoRepository mockVolcanoRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockVolcanoRepository.count()).thenReturn(1L);
        Assertions.assertTrue(volcanoService.areImported());
    }
}