FROM eclipse-temurin:21-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the machine to the container
# Using a wildcard (*) so we don't have to worry about version numbers (e.g. 0.0.1-SNAPSHOT)
COPY target/*.jar app.jar

# Running on port 8081
EXPOSE 8081

# Start the app when the container turns on
ENTRYPOINT ["java", "-jar", "app.jar"]