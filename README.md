# PlayerApiApplication

This is the documentation for the PlayerApiApplication project.

## Overview

PlayerApiApplication is a Spring Boot application that serves as a RESTful API for managing player data in a fantasy sports league. It leverages Docker, Gradle, and Testcontainers for easy deployment and testing.

## Getting Started

To get started with PlayerApiApplication, follow these steps:

1. Ensure you have Docker, Gradle, and Java 17 (or higher) installed on your system.
2. Clone this repository: `git clone <repository-url>`
3. Navigate to the project directory: `cd player-api-application`
4. Build the project: `./gradlew build`
5. Run the tests: `./gradlew test`
6. Start the application: `./gradlew bootRun`

The application will be available at `http://localhost:8080`.

## Project Structure

The project follows a standard Spring Boot structure:

* `src/main/java`: Contains the main application and business logic.
* `src/test/java`: Contains test classes for the application.
* `src/main/resources`: Contains static resources like `application.properties` and `application.yml`.
* `src/test/resources`: Contains test resources like `test.properties` and `application.yml`.

## Configuration

The application's configuration is managed using `application.properties` or `application.yml`. These files are located in the `src/main/resources` directory.

## Deployment

To deploy the application, use Docker. First, build the Docker image:
sql
./gradlew build docker dockerImage

Then, run the Docker container:


arduino
docker run -p 8080:8080

The application will be available at `http://localhost:8080`.

## Tests

The project uses JUnit 5 for unit testing. To run the tests, use:


bash
./gradlew test

This will execute all test classes in the `src/test/java` directory.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [Gradle](https://gradle.org/)
* [Testcontainers](https://www.testcontainers.org/)
