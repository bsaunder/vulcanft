# VulcanFT-SVGService

## Technology Stack
- Java / Spring Boot
- Thymeleaf - Template Engine
- Apache Batik - SVG Image Processing
- MySQL  - Database

## Development Environment Setup
1. Install [Git](https://git-scm.com/)
2. Install [VS Code](https://code.visualstudio.com/)
3. Install VS Code Extensions
    - [MySQL](https://marketplace.visualstudio.com/items?itemName=cweijan.vscode-mysql-client2)
    - [Preview](https://marketplace.visualstudio.com/items?itemName=searKing.preview-vscode)
    - [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
    - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
    - [Docker for VSCode](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-docker)
4. Clone code repo
5. `$ cd VulcanFT-SVGService`
6. `$ mvn clean install`

## Running the Service
`mvn spring-boot:run`

## Generating Images
Use the following curl commands to generate sample labels and verify the service is working.

### Curl Command to Generate Label via POST
```
curl -X POST http://localhost:8080/api/label/filament -H "Content-Type: application/json" -d '{
    "spoolId": 105,
    "brand": "Bambu Lab",
    "type": "PLA",
    "line": "Dual Gradient",
    "sku": "11001",
    "colorName": "Ivory White",
    "colorHex": "F78F77",
    "nozzleTemp": "990-530",
    "bedTemp": "35-60",
    "maxPrintSpeed": 80,
    "dryingTemp": 150,
    "dryingTime": 8,
    "maxRh": 10,
    "dryingRequired": true,
    "amsCompatible": true,
    "toxicFumes": true
}
' --output output.png
```

### Curl Command to Generate Label via GET
```
curl -X GET http://localhost:9000/api/label/filament?brand=Bambi%20Labs&spoolId=105&type=PP6&line=Pro&sku=11001&colorName=Ivorys%20White&colorHex=FF00FF&nozzleTemp=990-530&bedTemp=35-60&maxPrintSpeed=80&dryingTemp=150&dryingTime=8&maxRh=10&dryingRequired=true&amsCompatible=true&toxicFumes=false --output output.png
```

## Triming Label Images
> **NOTE**: This was resolved and the images are now trimmed during generation. Manual trimming is no longer needed. 

The labels when generated contain a 37x245 blank space on the sides of each label that needs to be trimmed before printing. The following command can be used to trim the image and remove its blank space. 

### Install Image Magick
Follow the instructions to install Image Magick for your operating system from [here](https://imagemagick.org/script/download.php). 

### Trimming Image Blank Space
1. Save generated image as `output.png`
2. Trim with the command `magick output.png -trim trimmed.png`
3. `trimmed.png` is the new image without the blank space

## Printing Label Image
The generated image is 1960x1470 pixels in size. In order to print the image at the size of a Bambu Labs filament label, it shouldd be resized to `2.99" x 2.24"` or `76mm x 57mm` in your printer software. It is also recommended to add a border in order to make cutting out the label easier.  

## Building & Deploying the Docker Image
### Manually
1. `docker buildx build . -t vulcanft-svgservice` or specify a tag with `docker buildx build . -t vulcanft-svgservice:<TAG>`
2. `docker run -p 9000:8080 --restart=unless-stopped -d vulcanft-svgservice:latest`

### With Maven
1. `mvn clean package`

## Push the Docker Image to Docker Hub (Optional)
If you want to push the Docker image to a registry (e.g., Docker Hub), first log in to your Docker Hub account:
```
docker login
```
Then push the image:
```
docker push myusername/vulcanft-svgservice:latest
```
Ensure you replace myusername with your actual Docker Hub username.