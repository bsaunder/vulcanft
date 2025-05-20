# VulcanFT Inventory Service

## Technology Stack
- Java / Spring Boot
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
5. `$ cd inventory-service`
6. `$ mvn clean install`

## Running the Service
`mvn spring-boot:run` 

## Building & Deploying the Docker Image
### Manually
1. `docker buildx build . -t vulcanft-invservice` or specify a tag with `docker buildx build . -t vulcanft-invservice:<TAG>`
2. `docker run -p 9000:8080 --restart=unless-stopped -d vulcanft-invservice:latest`

## Push the Docker Image to Docker Hub (Optional)
If you want to push the Docker image to a registry (e.g., Docker Hub), first log in to your Docker Hub account:
```
docker login
```
Then push the image:
```
docker push myusername/vulcanft-invservice:latest
```
Ensure you replace myusername with your actual Docker Hub username.