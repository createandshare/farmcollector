package ca.devstaff.farmcollector.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.devstaff.farmcollector.model.Field;
import ca.devstaff.farmcollector.service.FieldService;

@RestController
@RequestMapping("/api/v1")
public class FieldController {

    @Autowired
    private FieldService service;

    @PostMapping("/planted")
    public ResponseEntity<Field> savePlantedFields(@RequestBody Field field) {
        return ResponseEntity.ok(service.savePlantedFields(field));
    }
    
    @PutMapping("/harvested")
    public ResponseEntity<Field> updatePlantedField(@RequestBody Field field) {
        return ResponseEntity.ok(service.updatePlantedField(field));
    }
    
    @GetMapping("/report/season")
    public ResponseEntity<List<Field>> getPlantedFields(
    									@RequestParam(required = false, value="cropType") String cropType,
    									@RequestParam(required = false, value="farmName") String farmName){ 
    	Map<String,String> aggregators = new HashMap<>();
    	aggregators.put("cropType", cropType);
    	aggregators.put("farmName", farmName);
    	return ResponseEntity.ok(service.getPlantedFields(aggregators));
    }
}
