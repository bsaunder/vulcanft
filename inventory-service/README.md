# VulcanFT Inventory Service

## Description
The Inventory Service manages brands, filament rolls and parts for VulcanFT. It provides REST APIs backed by a MySQL database.

## Tech Stack
- Java 21 with Spring Boot 3
- Spring MVC, Data JPA and Thymeleaf
- MySQL
- Maven

## How to Run
```bash
mvn spring-boot:run
```
The service starts on port `8080` and requires a running MySQL instance configured in `application.properties`.

## Testing
Run all tests with:
```bash
mvn test
```

## Documentation
If Spring REST Docs is configured, generate docs using:
```bash
mvn verify
```
Documentation will be placed in `target/generated-docs`.

## Container
### Build
```bash
docker buildx build . -t vulcanft-invservice:latest
```
### Run locally (Mac/Windows Docker Desktop)
```bash
docker run -p 9000:8080 --rm vulcanft-invservice:latest
```
### Push to Docker Hub
Replace `<username>` with your Docker Hub ID:
```bash
docker tag vulcanft-invservice:latest <username>/vulcanft-invservice:latest
docker push <username>/vulcanft-invservice:latest
```
