package ca.devstaff.farmcollector.test;

import ca.devstaff.farmcollector.model.Field;
import ca.devstaff.farmcollector.model.FieldRepository;
import ca.devstaff.farmcollector.service.FieldService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@DisplayName("When testing Field")
class FieldServiceTest {

    @Mock
    private FieldRepository repository;

    @InjectMocks
    private FieldService fieldService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("save should create a new field")
    void testSavePlantedFields() {
        Field field = new Field();

        when(repository.save(field)).thenReturn(field);

        Field savedField = fieldService.savePlantedFields(field);

        assertNotNull(savedField);
        verify(repository, times(1)).save(field);
    }

    @Test
    @DisplayName("update should update a new field")
    void testUpdatePlantedField() {
        Field existingField = new Field();
        existingField.setId(1L);
        existingField.setHarvestedProduct(10.0);

        Field updatedField = new Field();
        updatedField.setId(1L);
        updatedField.setHarvestedProduct(20.0);

        when(repository.findById(anyLong())).thenReturn(Optional.of(existingField));
        when(repository.save(any(Field.class))).thenReturn(existingField);

        Field result = fieldService.updatePlantedField(updatedField);

        assertNotNull(result);
        assertEquals(20.0, result.getHarvestedProduct());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(existingField);
    }

    @Test
    @DisplayName("get should return a list of fields")
    void testGetPlantedFields() {
        Field field1 = new Field();
        field1.setCropType("Corn");
        field1.setFarmName("Farm1");

        Field field2 = new Field();
        field2.setCropType("Wheat");
        field2.setFarmName("Farm2");

        List<Field> fields = Arrays.asList(field1, field2);
        when(repository.findAll()).thenReturn(fields);

        Map<String,String> aggregators = new HashMap<>();
        aggregators.put("cropType", "Rice");
        
        List<Field> result = fieldService.getPlantedFields(aggregators);

        assertNotNull(result);
        // Assuming getPlantedFields should return all fields for the given aggregators
        assertEquals(0, result.size()); // Adjust as per the logic required
        verify(repository, times(1)).findAll();
    }
}

