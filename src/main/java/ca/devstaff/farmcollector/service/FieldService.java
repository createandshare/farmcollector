package ca.devstaff.farmcollector.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.devstaff.farmcollector.model.Field;
import ca.devstaff.farmcollector.model.FieldRepository;

@Service
public class FieldService {

	@Autowired
    private FieldRepository repository;

    public Field savePlantedFields(Field field) {
        return repository.save(field);
    }
    
    public Field updatePlantedField(Field updatedField) {
    	Field savedField = repository.findById(updatedField.getId()).orElseThrow(RuntimeException::new);
    	savedField.setHarvestedProduct(updatedField.getHarvestedProduct()); 
    	repository.save(savedField);
    	return savedField;
    }
    
    public List<Field> getPlantedFields(Map<String,String> aggregators) {
    	List<Field> result = repository.findAll();
		if(aggregators.containsKey("cropType") && aggregators.get("cropType")!=null) {
			result = result.stream().filter(e -> e.getCropType().equalsIgnoreCase(aggregators.get("cropType"))).collect(Collectors.toList());
		}
		if(aggregators.containsKey("farmName") && aggregators.get("farmName")!=null) {
			result = result.stream().filter(e -> e.getFarmName().equalsIgnoreCase(aggregators.get("farmName"))).collect(Collectors.toList());
		}
        return result;
    }
}
