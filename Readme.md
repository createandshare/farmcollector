# FarmCollector

## Overview

**FarmCollector** is a Spring Boot application designed to collect and manage information from farmers about their fields for each season. The application supports two main functionalities via APIs:

1. **Planted Fields**: Collect data about the fields that have been planted, including:
   * Planting area (in acres)
   * Type of crops planted
   * Expected product amount (in tons)

2. **Harvested Fields**: Collect data about the fields that have been harvested, including:
   * Actual amount of harvested product

The application also generates reports that compare the expected versus actual product amounts for each farm and each crop type for every season.

## Technologies Used

- **Java 17**: The latest LTS version of Java, ensuring modern language features and improvements.
- **Spring Boot**: A framework to simplify the development of Java applications.
- **H2 Database**: An in-memory database for quick and easy setup.
- **JUnit 5**: A powerful testing framework for Java applications.
- **Mockito**: A mocking framework for unit tests.

## Test Coverage

The project includes comprehensive unit tests using JUnit 5 and Mockito, covering the service layer to ensure the business logic is working correctly. 

## Project Setup

### Prerequisites

- Java 17
- Maven

### Steps to Set Up Locally

1. **Clone the Repository**

   ```sh
   git clone https://github.com/createandshare/farmcollector.git
   cd farmcollector
   ```

2. **Build the Project**

   ```sh
   mvn clean install
   ```

3. **Run the Application**

   ```sh
   mvn spring-boot:run
   ```

4. **Access the H2 Database Console**

   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`

5. **API Endpoints**

   - **Save Planted Fields**: `POST /api/v1/planted`
   - **Update Harvested Fields**: `PUT /api/v1/harvested`
   - **Get Report for seasons**: `GET /api/v1/report/season`
   - **Get Report for seasons by crop type**: `GET /api/v1/report/season?cropType=Wheat`
   - **Get Report for seasons by farm name**: `GET /api/v1/report/season?farmName=Farm1`

### Running Tests

To run the tests, use the following command:

```sh
mvn test
```

## How to Contribute

We welcome contributions! Follow these steps to contribute:

1. **Fork the Repository**

   Click the "Fork" button on the top right of the repository page to fork your own copy of the repository.

2. **Clone Your Fork**

   ```sh
   git clone https://github.com/createandshare/farmcollector.git
   cd farmcollector
   ```

3. **Create a Branch**

   Create a new branch for your feature or bugfix.

   ```sh
   git checkout -b feature/your-feature-name
   ```

4. **Make Your Changes**

   Implement your changes in the codebase.

5. **Commit and Push**

   ```sh
   git add .
   git commit -m "Add your meaningful commit message"
   git push origin feature/your-feature-name
   ```

6. **Create a Pull Request**

   Go to the original repository on GitHub and create a pull request from your forked repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any queries or feedback, feel free to reach out to the project maintainers:

- **Your Name**: [amritpals90@gmail.com](mailto:amritpals90@gmail.com)

---

Thank you for contributing to FarmCollector! Together, we can make this project better for farmers and organizations alike.