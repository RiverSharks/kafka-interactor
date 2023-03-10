# Set the base image to Maven 3.8.3 OpenJDK 11
FROM maven:3.8.3-openjdk-11-slim AS build

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml and the rest of the project into the container
COPY pom.xml /app/
COPY src /app/src/

# Build the application using Maven
RUN mvn clean package -DskipTests

# Set the base image to OpenJDK 11
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file from the build stage
COPY --from=build /app/target/app.jar /app/app.jar

COPY docker/run.sh /app

RUN chmod +x /app/run.sh

# Expose port 8080
EXPOSE 8080

# Set entrypoint
ENTRYPOINT  ["/app/run.sh"]