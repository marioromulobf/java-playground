### Java Spring Session in Memory with Load Balance POC

### Tech Stack
* Java 25 (LTS)
* Maven 3.x
* Docker
* Nginx

### How to Build
```bash
mvn clean install
```

### How to Run Local
```bash
mvn spring-boot:run
```

### How to Build and Run with Docker
```bash
# Build the Docker image
docker compose -p lb up -d
```

### How to Stop and Remove Containers
```bash
docker compose -p lb down
```


### Endpoints
* `GET /count-access-session` - Public endpoint to count the number of accesses in the current session.

### How to Run Tests
```bash
mvn test
```

### Notes
* This is a simple proof of concept (POC) for managing sessions in memory using Java Spring.
* Sessions are stored in memory and cookies, which means they will be lost when:
  * the application is restarted, or
  * after a certain timeout period (5m - see application.properties), or
  * when the user clears their cookies.