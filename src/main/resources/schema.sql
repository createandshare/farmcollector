CREATE TABLE FIELD (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    field_name VARCHAR(255) NOT NULL,
    farm_id BIGINT,
    farm_name VARCHAR(255) NOT NULL,
    season VARCHAR(255) NOT NULL,
    planting_area DOUBLE NOT NULL,
    crop_type VARCHAR(255) NOT NULL,
    expected_product DOUBLE NOT NULL,
    harvested_product DOUBLE NOT NULL
);
