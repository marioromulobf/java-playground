# Java - Quartz POC

Proof of Concept demonstrating the [Quartz](https://www.quartz-scheduler.org/) scheduler integrated with Spring Boot.

## Tech Stack

- Java 25 (LTS)
- Maven 3.x
- Spring Boot 4.1.0
- Quartz
- PostgreSQL
- JUnit 6.1.2

## Build

```bash
mvn clean compile
```

## Run

```bash
mvn clean spring-boot:run
```

Or run directly:

```bash
java -cp target/classes com.mariofernandes.javapoc.quartz.Main
```

The application starts on port `8080`.

## POCs Without HTTP Endpoints

`POC01`, `POC02`, `POC03`, and `POC04` are internal Quartz configurations automatically initialized by the application:

- **POC01**: job execution with simple intervals.
- **POC02**: different repetition and completion configurations.
- **POC03**: scheduling with cron expressions.
- **POC04**: use of context data (`JobDataMap`) during executions.

## Endpoints

### POC05 — Create Simple Jobs

Creates a dynamic job with an interval in seconds and a repetition count defined in the request.

#### `POST /api/poc05/jobs`

```bash
curl --request POST 'http://localhost:8080/api/poc05/jobs' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "example",
    "intervalSeconds": 10,
    "repeatCount": 3
  }'
```

Expected response: `202 Accepted`.

---

### POC06 — Jobs Using Cron Expressions

#### Create a job

##### `POST /api/poc06/jobs`

```bash
curl --request POST 'http://localhost:8080/api/poc06/jobs' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "example",
    "cronExpression": "0/10 * * * * ?"
  }'
```

Expected response: `202 Accepted`.

#### Retrieve a job

##### `GET /api/poc06/jobs/{name}`

```bash
curl --request GET 'http://localhost:8080/api/poc06/jobs/example'
```

Example response:

```json
{
  "name": "exampleJob",
  "group": "poc06",
  "triggerState": "NORMAL",
  "cronExpression": "0/10 * * * * ?",
  "previousFireTime": "Tue Sep 29 21:20:00 BRT 2026",
  "nextFireTime": "Tue Sep 29 21:20:10 BRT 2026"
}
```

#### Update the cron expression

##### `PUT /api/poc06/jobs`

```bash
curl --request PUT 'http://localhost:8080/api/poc06/jobs' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "example",
    "cronExpression": "0/30 * * * * ?"
  }'
```

Expected response: `202 Accepted`.

#### Delete a job

##### `DELETE /api/poc06/jobs/{name}`

```bash
curl --request DELETE 'http://localhost:8080/api/poc06/jobs/example'
```

Expected response: `204 No Content`.

---

### POC07 — Misfire Handling Strategies

These endpoints create jobs using a cron expression and allow you to choose how Quartz handles missed executions:

- `fire-and-proceed`: executes immediately after a misfire and continues with the schedule.
- `do-nothing`: ignores the misfire and waits for the next scheduled execution.

The `dataMap` field is optional.

#### Fire immediately after a misfire

##### `POST /api/poc07/misfire/fire-and-proceed`

```bash
curl --request POST 'http://localhost:8080/api/poc07/misfire/fire-and-proceed' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "example",
    "cronExpression": "0/10 * * * * ?",
    "dataMap": {
      "environment": "dev",
      "source": "curl"
    }
  }'
```

Expected response: `202 Accepted`.

#### Ignore the misfire

##### `POST /api/poc07/misfire/do-nothing`

```bash
curl --request POST 'http://localhost:8080/api/poc07/misfire/do-nothing' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "example",
    "cronExpression": "0/10 * * * * ?",
    "dataMap": {
      "environment": "dev",
      "source": "curl"
    }
  }'
```

Expected response: `202 Accepted`.