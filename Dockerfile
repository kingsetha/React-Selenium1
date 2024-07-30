# Stage 1: Build the frontend
FROM node:18-alpine AS frontend-build

# Set the working directory for the frontend
WORKDIR /frontend

# Copy the frontend package.json and package-lock.json
COPY target/Assessment_Manual/package*.json ./

# Install frontend dependencies
RUN npm install

# Copy the rest of the frontend code
COPY target/Assessment_Manual/ ./

# Build the frontend
RUN npm run build

# Stage 2: Build the backend
FROM openjdk:17-jdk-alpine

# Set the working directory for the backend
WORKDIR /app

# Copy the backend JAR file to the container
COPY target/SeleniumCheckJen-0.0.1-SNAPSHOT.jar app.jar

# Copy the frontend build files to the backend static resources directory
COPY --from=frontend-build /frontend/build /app/src/main/resources/static

# Expose the port the application runs on
EXPOSE 1002

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
