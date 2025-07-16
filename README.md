#  Spring Boot Church API

##  Church Management System

A Spring Boot-powered backend API for managing church operations including members, departments, events, families, contributions, announcements, sermons, and attendance tracking.

---

##  Technologies Used

- Java 17
- Spring Boot 3.5.0
- PostgreSQL Database
- Spring Data JPA
- Spring Web
- Maven

---

##  Project Structure & Design Principles

This project follows the **Separation of Concerns (SoC)** principle and clean architecture:

###  Layered Architecture

| Layer                                                 | Description                                                                           |
|-------------------------------------------------------|---------------------------------------------------------------------------------------|
| **Controller**                                        | Handles HTTP requests and delegates to the service layer                              |
| **Service interface and service implemenation class** | Interface define the methods and its implementation class contains the business logic |
| **Repository**                                        | Interacts with the PostgreSQL database via Spring Data JPA                            |
| **DTOs**                                              | Used for API data transfer — no entity exposure                                       |
| **Mappers**                                           | Convert between DTOs and Entities                                                     |
| **Entities**                                          | Represent database tables                                                             |
| **ApiResponse<T>**                                    | Standard response format for all endpoints                                            |
| **Exception Handlers**                                | Global handler to catch and respond with meaningful errors                            |

###  Benefits:
- Scalable and maintainable
- Clean and reusable code
- API consistency with custom response wrapper
- Separation of business logic from web logic

---

##  Global Exception Handling

A centralized exception handler (`GlobalExceptionHandler`) is implemented using `@ControllerAdvice`, which manages:

- `ResourceNotFoundException`
- `IllegalArgumentException`
- Validation errors
- Any unexpected exceptions

It ensures clients receive consistent and descriptive error messages.

Example Error Response:

```json
{
  "status": "error",
  "message": "Member not found with ID: 5",
  "data": null
}
```
##  Clone the Project

```bash

# Clone the repository to your local machine

git clone https://github.com/Collins0399/springboot-church-api.git

cd church-management-system

```
## Configure the Database
1. Create a PostgreSQL database:

CREATE DATABASE churchdb;

2. Configure application.yml located at src/main/resources/application.yml:
yaml
````
server:
  port: 9001

spring:
  application:
    name: Church

  datasource:
    url: jdbc:postgresql://localhost:5432/ChurchTest_Db
    username: your_username
    password: your_password
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
 
 ```` 
## Run the Application
## Option 1:Using Maven (Terminal)
 ````
mvn clean install
mvn spring-boot:run
 ````

## Option 2: Using IntelliJ IDEA
Open the project in your IDE.

Locate the main class: ChurchManagementSystemApplication.java

Right-click → Run.

Access the app at:
````
http://localhost:9001
````
