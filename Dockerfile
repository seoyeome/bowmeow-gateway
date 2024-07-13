# Use an official OpenJDK 21 runtime as a parent image
FROM openjdk:21-jdk-slim

LABEL authors="sohyun-seoyoung"

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file to the container
COPY build/libs/gateway-0.0.1-SNAPSHOT.jar /app/bow-meow-gateway.jar

# Expose the port that the application runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "bow-meow-gateway.jar"]
