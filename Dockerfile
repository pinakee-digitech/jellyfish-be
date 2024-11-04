# Build Stage
FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk maven -y
COPY . .
RUN mvn clean package

# Run Stage
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copy the built JAR file from the build stage to the run stage
COPY --from=build /build/libs/JellyFish-1.jar app.jar

# Run the application
ENTRYPOINT [ "java", "-jar", "app.jar" ]