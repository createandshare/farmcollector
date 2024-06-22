package ca.devstaff.farmcollector.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fieldName;
    private Long farmId;
    private String farmName;
    private String season;
    private Double plantingArea;
    private String cropType;
    private Double expectedProduct;
    private Double harvestedProduct;
}
