# Start with a base image that has OpenJDK 17
FROM openjdk:17-jdk-slim

# Add a volume to persist logs or other data, if needed
VOLUME /tmp

# Expose the application port (8080 by default for Spring Boot)
EXPOSE 8080

# Copy the Spring Boot JAR file into the container
ARG JAR_FILE=./build/libs/PlayerAPI.jar
COPY ${JAR_FILE} app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]