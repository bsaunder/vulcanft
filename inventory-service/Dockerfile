# Use an official OpenJDK runtime as a parent image
FROM ubuntu:20.04

ARG JAR_FILE=vulcanft-invservice.jar

# Set the working directory inside the container
WORKDIR /app

# Set environment variables to avoid interactive prompts during installation
ENV DEBIAN_FRONTEND=noninteractive

# Update package list and install OpenJDK (change version if necessary)
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    && rm -rf /var/lib/apt/lists/*

# Verify the Java installation
RUN java -version

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Copy the Spring Boot JAR file from the host to the container
COPY target/${JAR_FILE} app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]