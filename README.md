# Spring Boot Demo

This project is a simple demonstration of a Spring Boot application. It showcases the basic structure, configuration, and functionality of a Spring Boot project.

## Features

- RESTful API endpoints
- Dependency Injection with Spring Framework
- Configuration using `application.properties`
- Integration with a database (e.g., H2, MySQL, or PostgreSQL)
- Basic error handling and logging

## Prerequisites

- Java 17 or higher
- Maven 3.8+ or Gradle 7+
- An IDE like IntelliJ IDEA, Eclipse, or VS Code

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/RonyOz/springboot-demo.git
    cd springboot-demo
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

4. Access the application:
    Open your browser and navigate to `http://localhost:8080`.

## Configuration

Modify the `src/main/resources/application.properties` file to configure the application. For example, you can set the database connection details or change the server port.
