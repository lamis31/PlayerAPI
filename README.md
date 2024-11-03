# PlayerApiApplication


## Overview

The Player API Application is a Java-based Spring Boot application designed to manage and retrieve player data. This application uses a RESTful API approach and leverages Spring Data JPA for data persistence, with PlayerRepository providing CRUD operations and pagination for managing player entities.
## Getting Started

To get started with PlayerApi application, follow these steps:

1. Ensure you have Docker, Gradle, and Java 17 (or higher) installed on your system.
2. Clone this repository: `git clone https://github.com/lamis31/PlayerAPI`
3. Navigate to the project directory: `cd PlayerAPI`
4. Build the project: `./gradlew build`
5. Run the tests: `./gradlew test`
6. Start the application: `./gradlew bootRun`

The application will be available at `http://localhost:8080`.

Swagger documentation will be available at `http://localhost:8080/swagger-ui/index.html`

## Project Structure

The project follows a standard Spring Boot structure:

* `src/main/java`: Contains the main application and business logic.
* `src/test/java`: Contains test classes for the application.
* `src/main/resources`: Contains static resources like `application.properties` and `application.yml`.
* `src/test/resources`: Contains test resources like `test.properties` and `application.yml`.

## Dependencies
Key dependencies used in this project:

* Spring Boot - Application framework
* Spring Data JPA - Database interaction and ORM support
* Lombok - Reduces boilerplate for model classes
A full list of dependencies is available in the build.gradle file.

## Documentation

See Swagger documentation at `http://localhost:8080/swagger-ui/index.html`


## Troubleshooting

Ensure the database service is running and properly configured.
Verify that all required environment variables are set.

## Contributors
Your Name - Yuli Livshits

## Configuration

The application's configuration is managed using `application.properties` located in the `src/main/resources` 
directory. Customize database connection settings and other properties here if needed.

## Deployment

To deploy the application, use Docker. First, build the Docker image:
sql
./gradlew build docker dockerImage

Then, run the Docker container:



docker run -p 8080:8080

The application will be available at `http://localhost:8080`.


## Out Of Scope

* Data Validation

* Security and Authentication 
* Performance and Query Optimization 







## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [Gradle](https://gradle.org/)
