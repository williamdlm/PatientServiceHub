# Patient Service Hub

## Overview

Patient Service Hub is a Java-based project designed for the management of patient records. The service supports both RESTful and SOAP web services, allowing for versatile integration options. The project leverages Spring Boot, Spring Data JPA, Apache CXF, and Apache Camel to provide robust and scalable functionality.

## Features

- **Patient Registration**: Add new patients to the system.
- **Patient Lookup**: Retrieve patient information using a unique document ID.
- **List Patients**: Fetch a list of all registered patients.
- **SOAP and REST**: Dual support for SOAP and RESTful web services.

## Technologies Used

- **Spring Boot**: Framework for building microservices.
- **Spring Data JPA**: Data access abstraction to work with relational databases.
- **Apache CXF**: Framework for building and developing web services.
- **Apache Camel**: Integration framework to facilitate communication between various systems.
- **Lombok**: Reduces boilerplate code.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.8.1 or higher
- Docker (optional, for running a database)

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/patient-service-hub.git
   cd patient-service-hub
   ```

2. **Configure Database**
   Update the `application.properties` file in `src/main/resources` with your database configurations.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/patient_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

### Usage

#### REST Endpoints

- **List All Patients**
  ```http
  GET /patients
  Response: 200 OK
  [
      {
          "id": 1,
          "firstName": "John",
          "lastName": "Doe",
          "codeDocumentId": "1234",
          "birthDate": "1990-01-01"
      },
      ...
  ]
  ```

- **Get Patient by Document ID**
  ```http
  GET /patients/{codeDocumentId}
  Response: 200 OK
  {
      "id": 1,
      "firstName": "John",
      "lastName": "Doe",
      "codeDocumentId": "1234",
      "birthDate": "1990-01-01"
  }
  ```

- **Add New Patient**
  ```http
  POST /patients
  Request Body:
  {
      "firstName": "John",
      "lastName": "Doe",
      "codeDocumentId": "1234",
      "birthDate": "1990-01-01"
  }
  Response: 201 Created
  ```

#### SOAP Endpoints

The SOAP endpoint is published at:
```
http://localhost:8080/soap/hello?wsdl
```

You can use tools like SOAP UI to interact with the SOAP service. The available operations are `findByDocumentId`, `savePatient`, and `findAllPatient`.

## Project Structure

- **controller**: Contains REST controllers for handling HTTP requests.
- **service**: Contains service classes and business logic.
- **config**: Configuration classes for Apache CXF and other beans.
- **model**: Entity classes representing the data model.
- **repository**: JPA repositories for database access.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License.


---
