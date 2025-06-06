# VulcanFT SVG Service

## Description
The SVG Service generates printable PNG images from SVG templates. It exposes REST endpoints used by Vulcan Filament Tracker to create filament spool labels.

## Tech Stack
- Java 21 with Spring Boot 3
- Spring MVC and Thymeleaf
- Apache Batik for SVG to PNG conversion
- Spring REST Docs with Asciidoctor
- Maven

## How to Run
```bash
mvn spring-boot:run
```
The service listens on port `8080`.

## Generating Labels
You can request a label image using either POST or GET.

**POST Example**
```bash
curl -X POST http://localhost:8080/api/label/filament \
  -H "Content-Type: application/json" \
  -d '{"spoolId":"1","brand":"Bambu Lab","type":"PLA"}' \
  --output label.png
```

**GET Example**
```bash
curl "http://localhost:8080/api/label/filament?spoolId=1&brand=Bambu%20Lab&type=PLA" \
  --output label.png
```

## Testing
Execute the unit tests with:
```bash
mvn test
```

## Documentation
Generate the HTML API docs using:
```bash
mvn verify
```
After the build completes, open `target/generated-docs/index.html` in a browser.

## Container
### Build
```bash
docker buildx build . -t vulcanft-svgservice:latest
```
### Run locally (Mac/Windows Docker Desktop)
```bash
docker run -p 9000:8080 --rm vulcanft-svgservice:latest
```
### Push to Docker Hub
Replace `<username>` with your Docker Hub ID:
```bash
docker tag vulcanft-svgservice:latest <username>/vulcanft-svgservice:latest
docker push <username>/vulcanft-svgservice:latest
```
