### Java Spring Session in Memory POC

### Tech Stack
* Java 25 (LTS)
* Maven 3.x

### How to Build
```bash
mvn clean install
```

### How to Run
```bash
mvn spring-boot:run
```
### Endpoints
* `GET /set-attribute?name=Mario` - Public endpoint to set session attribute `user_name`.
* `GET /get-attribute` - Public endpoint to get session attribute `user_name`.
* `GET /invalidate` - Public endpoint to invalidate the current session.
* `GET /count-access-session` - Public endpoint to count the number of accesses in the current session.

### How to Run Tests
```bash
mvn test
```

### Notes
* This is a simple proof of concept (POC) for managing sessions in memory using Java Spring.
* Sessions are stored in memory, which means they will be lost when the application is restarted or after a certain timeout period (1m - see application.properties).