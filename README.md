# springboot-church-api
## Church Management System

A Spring Boot application designed to help churches manage members, departments, events, contributions, announcements, families, sermons, and attendance effectively.

---

##  Technologies Used

- Java 17
- Spring Boot
- PostgreSQL
- Maven

---

##  Prerequisites

Before running this application, ensure you have the following installed:

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Git](https://git-scm.com/)

---

##  Clone the Project

```bash

# Clone the repository to your local machine
git clone https://github.com/Collins0399/springboot-church-api.git
cd church-management-system
⚙ Configure the Database
1. Create a PostgreSQL database:
sql
Copy
Edit
CREATE DATABASE churchdb;
2. Configure application.yml located at src/main/resources/application.yml:
yaml
Copy
Edit
server:
  port: 9001

spring:
  application:
    name: Church

  datasource:
    url: jdbc:postgresql://localhost:5432/churchdb
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
▶ Run the Application
🔹 Option 1: Using Maven (Terminal)
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
🔹 Option 2: Using IntelliJ IDEA
Open the project in your IDE.

Locate the main class: ChurchManagementSystemApplication.java

Right-click → Run.

Access the app at:
http://localhost:9001