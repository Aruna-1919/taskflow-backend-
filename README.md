# TaskFlow – Backend

A RESTful backend application for TaskFlow, a task management system, developed using Java and Spring Boot.

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL JDBC Driver
- Flyway Database Migration

## 📌 Day 1 – Development Progress

### 1. Project Initialization
- Created the Spring Boot backend application.
- Configured the Maven-based project.
- Set up the initial application structure.
- Configured Java 21 as the development environment.

### 2. Dependency Configuration
Added the initial dependencies required for backend development:

- Spring Data JPA for database persistence.
- PostgreSQL JDBC Driver for database connectivity.
- Flyway for database schema migration management.

### 3. Application Configuration
- Started configuring application properties.
- Identified the datasource configuration requirements.
- Worked on preparing the backend for database integration.

### 4. Database Setup
Database connectivity configuration is pending.

The application requires a valid datasource URL, credentials and database driver configuration before database-backed operations can run successfully.

## 📂 Project Structure

```text
taskflow-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## ⚙️ Installation and Setup

### Prerequisites
- JDK 21
- Maven
- IDE (IntelliJ IDEA / Eclipse / VS Code)
- Configured database

### Steps

1. Clone the repository:

```bash
git clone YOUR_BACKEND_REPOSITORY_URL
```

2. Navigate to the project:

```bash
cd taskflow-backend
```

3. Build the application:

```bash
mvn clean install
```

4. Configure the datasource in `application.properties` before starting the application.

5. Run the application:

```bash
mvn spring-boot:run
```

## 🔐 Configuration

Database credentials and environment-specific settings should be maintained outside source control.

Do not commit database passwords, API keys or other sensitive configuration.

## 🛣️ Development Roadmap

- [x] Initialize Spring Boot application
- [x] Configure Java 21
- [x] Add Spring Data JPA dependency
- [x] Add PostgreSQL driver dependency
- [x] Add Flyway dependency
- [ ] Complete database configuration
- [ ] Develop entity and repository layers
- [ ] Implement service layer
- [ ] Implement REST controllers
- [ ] Integrate Angular frontend
- [ ] Test APIs
- [ ] Prepare production deployment

## 👩‍💻 Project Development

**Project:** TaskFlow  
**Frontend:** Angular  
**Backend:** Spring Boot  
**Language:** Java 21  
**Build Tool:** Maven


## 📅 Day 2 – Spring Boot Backend Development & PostgreSQL Integration

**Objective:** Develop the core backend functionality for TaskFlow, establish PostgreSQL database connectivity, implement RESTful APIs for Task and Category management, and verify successful data persistence.

### 1. Backend Dependencies and Configuration

Configured the required Spring Boot dependencies in `pom.xml`:

- Spring Boot Starter Web – REST API development.
- Spring Data JPA – Database operations and ORM.
- PostgreSQL JDBC Driver – PostgreSQL connectivity.
- Flyway Core – Database schema version management.
- Flyway PostgreSQL – PostgreSQL migration support.
- Spring Boot Starter Validation – Request validation.
- Lombok – Reducing boilerplate code.

Configured the application datasource and Hibernate properties in `application.properties`.

- Connected Spring Boot to the PostgreSQL `taskflow` database.
- Configured Hibernate with `ddl-auto=validate`.
- Enabled Flyway database migrations.
- Verified database connectivity.

### 2. Database Design and Flyway Migration

Implemented database schema management using Flyway.

Created the initial migration script:

`src/main/resources/db/migration/V1__init.sql`

Created the following database tables:

| Table | Purpose |
|---|---|
| users | Stores user information |
| categories | Stores task categories |
| tasks | Stores task details and relationships |

**Database relationships:**

- Task → Category: Many-to-One.
- Task → User: Many-to-One.

Additional implementation:
- Configured primary keys and foreign key constraints.
- Used `BIGSERIAL` for auto-generated IDs.
- Used appropriate column types and constraints.
- Configured timestamp defaults.
- Used string-based enum persistence for task status and priority.
- Verified Flyway migration execution and database table creation.

### 3. Entity Layer Development

Created the following entity classes:

- `User`
- `Task`
- `Category`
- `TaskStatus`
- `Priority`

Implemented entity relationships using JPA annotations.

Configured task attributes including:
- Title
- Description
- Status
- Priority
- Due Date
- Created At
- Category
- User

Used `@Enumerated(EnumType.STRING)` to store readable status and priority values in PostgreSQL.

### 4. Repository Layer

Implemented Spring Data JPA repositories for database interaction.

- Created `TaskRepository`.
- Created `CategoryRepository`.
- Extended `JpaRepository` to utilize built-in persistence and retrieval operations.

### 5. DTO Layer

Implemented Data Transfer Objects to separate API request and response structures from database entities.

**Task DTOs:**
- `TaskRequest`
- `TaskResponse`

**Category DTOs:**
- `CategoryRequest`
- `CategoryResponse`

Implemented request validation and entity-to-DTO / DTO-to-entity conversions.

This approach helps maintain a clean separation between the persistence layer and API layer.

### 6. Service Layer

Implemented business logic for Task and Category management.

**Task Service:**
- Create a new task.
- Retrieve all tasks.
- Retrieve a task using its ID.
- Convert request DTOs into entities.
- Convert entities into response DTOs.
- Associate tasks with their respective categories.

**Category Service:**
- Create a new category.
- Retrieve all categories.
- Retrieve a category using its ID.
- Handle entity and DTO conversions.

### 7. Controller Layer – REST API Development

Implemented REST controllers to expose Task and Category operations.

**Task APIs**

| HTTP Method | Endpoint | Functionality |
|---|---|---|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Retrieve all tasks |
| GET | `/api/tasks/{id}` | Retrieve a task by ID |

**Category APIs**

| HTTP Method | Endpoint | Functionality |
|---|---|---|
| POST | `/api/category` | Create a new category |
| GET | `/api/category` | Retrieve all categories |
| GET | `/api/category/{id}` | Retrieve a category by ID |

### 8. CORS Configuration

Configured Cross-Origin Resource Sharing (CORS) to allow communication between the Angular frontend and Spring Boot backend.

- Allowed the Angular development server origin: `http://localhost:4200`.
- Prepared the backend APIs for frontend integration.

### 9. API Testing Using Postman

Performed REST API testing using Postman to validate backend functionality and database operations.

**Task API Testing:**

| Test Case | Method | Endpoint | Result |
|---|---|---|---|
| Create Task | POST | `/api/tasks` | Successful |
| Retrieve All Tasks | GET | `/api/tasks` | Successful |
| Retrieve Task by ID | GET | `/api/tasks/1` | Successful – 200 OK |

**Category API Testing:**

| Test Case | Method | Endpoint | Result |
|---|---|---|---|
| Create Category | POST | `/api/category` | Successful |
| Retrieve All Categories | GET | `/api/category` | Successful |
| Retrieve Category by ID | GET | `/api/category/1` | Successful |

**Postman Verification – Task Retrieval**

Tested the following endpoint:

`GET http://localhost:8080/api/tasks/1`

Received the following response:

- HTTP Status: `200 OK`
- Response Time: `171 ms`
- Response Size: `571 B`

Sample JSON response:

```json
{
  "id": 1,
  "title": "Complete Day 2 backend",
  "description": "Entities, Flyway migration, service and controller",
  "status": "TODO",
  "priority": "HIGH",
  "dueDate": "2026-11-20",
  "createdAt": "2026-11-13T22:24:21.095212",
  "categoryId": 3,
  "categoryName": "Study"
}
```

**Key observations from the response:**

- Successfully retrieved a task using its unique ID.
- Verified task attributes including title, description, status and priority.
- Confirmed due date and creation timestamp retrieval.
- Verified the associated category ID and category name.
- Confirmed successful HTTP response with `200 OK`.

### 10. PostgreSQL Data Persistence Verification

Verified that the data submitted through POST requests was successfully stored in PostgreSQL.

- Confirmed task records were persisted in the `tasks` table.
- Confirmed category records were persisted in the `categories` table.
- Verified that task and category relationships were maintained.
- Confirmed that data could subsequently be retrieved through GET APIs.

### 📸 Day 2 – Evidence and Testing

**Postman API Testing Screenshot**

The shared Postman screenshot demonstrates:

1. Successful GET request for `/api/tasks/1`.
2. HTTP `200 OK` response.
3. Correctly returned task details.
4. Task status and priority retrieval.
5. Associated category information.
6. Additional Task and Category POST and GET requests in the Postman request history.

### 🎯 Day 2 Key Achievements

- Completed the initial Spring Boot backend architecture.
- Integrated PostgreSQL with Spring Boot.
- Implemented Flyway database migrations.
- Developed Entity, Repository, DTO, Service and Controller layers.
- Implemented Task and Category REST APIs.
- Configured frontend-backend CORS communication.
- Tested API operations using Postman.
- Successfully persisted and retrieved application data from PostgreSQL.

### 🛣️ Updated Development Roadmap

- [x] Initialize Spring Boot backend.
- [x] Configure Java 21 and Maven.
- [x] Integrate PostgreSQL.
- [x] Configure Flyway migrations.
- [x] Develop User, Task and Category entities.
- [x] Implement repository and DTO layers.
- [x] Implement service and controller layers.
- [x] Develop Task and Category creation APIs.
- [x] Develop Task and Category retrieval APIs.
- [x] Configure CORS.
- [x] Test APIs using Postman.
- [x] Verify PostgreSQL data persistence.
- [ ] Implement update and delete APIs.
- [ ] Implement authentication and authorization.
- [ ] Integrate Angular frontend with backend APIs.
- [ ] Implement exception handling.
- [ ] Perform end-to-end testing.
- [ ] Prepare production deployment.

---

**Day 2 Status: Core Backend APIs Implemented and Tested Successfully**

The initial backend foundation of TaskFlow is complete, with working Task and Category APIs, PostgreSQL integration, and verified data persistence.



## 📅 Day 3 – Spring Security & JWT Authentication

**Objective:** Secure the TaskFlow backend by implementing user registration and login with BCrypt password hashing and stateless JWT authentication using Spring Security. Build a custom JWT filter to validate tokens on every request, restrict task APIs to authenticated users, and verify the complete authentication flow through Postman testing.

## Progress

| Day | Work done |
|-----|-----------|
| 1 | Project setup, PostgreSQL connection, `/actuator/health` |
| 2 | Task and Category REST APIs, Flyway migrations, tested in Postman |
| 3 | User registration and login, JWT authentication, per-user task access |

**Status of Day 3:** register, login, `GET /api/tasks` and `POST /api/tasks` work. `PUT /api/tasks/{id}` and `GET /api/tasks/{id}` still have issues and will be fixed next.

## Project Structure

```
src/main/java/com/taskflow/tasks/
├── config/        SecurityConfig (rules, CORS, BCrypt, filter order)
├── security/      JwtService, JwtAuthFilter, CustomUserDetailsService
├── controller/    AuthController, TaskController, CategoryController
├── service/       AuthService, TaskService
├── repository/    UserRepository, TaskRepository, CategoryRepository
├── entity/        User, Tasks, Category
└── dto/           RegisterRequest, LoginRequest, AuthResponse, UserResponse, TaskRequest, TaskResponse

src/main/resources/
├── application.properties
└── db/migration/  Flyway SQL files
```

## API Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/api/auth/register` | Public | Create an account |
| POST | `/api/auth/login` | Public | Log in and receive a JWT |
| GET | `/actuator/health` | Public | Health check |
| GET | `/api/tasks` | Bearer token | List the logged-in user's tasks |
| POST | `/api/tasks` | Bearer token | Create a task |
| GET | `/api/tasks/{id}` | Bearer token | Get one task (in progress) |
| PUT | `/api/tasks/{id}` | Bearer token | Update a task (in progress) |
| DELETE | `/api/tasks/{id}` | Bearer token | Delete a task (planned) |

## Understanding the Request Flow (Security)

### Login and register

Every request in the application first passes through the Spring Security filter chain, including login and register. For these two APIs, `JwtAuthFilter` runs but finds no `Authorization` header, so it does nothing and passes the request along. `AuthorizationFilter` then sees that `/api/auth/**` is configured as `permitAll`, so the request is allowed through to `AuthController`.

- **Register:** `AuthController` calls `AuthService.register()`, which checks that the email isn't already used, hashes the password with BCrypt, and saves the user in PostgreSQL. No token is created at registration.
- **Login:** `AuthController` calls `AuthService.login()`, which uses `AuthenticationManager` to authenticate the user. `AuthenticationManager` loads the user from the database through `CustomUserDetailsService` and compares the typed password with the stored BCrypt hash. If the credentials are correct, `AuthService` calls `JwtService.generateToken()` to create and sign the JWT with the secret key. The token is returned to the client in the response body. The server does not store the token anywhere. Angular saves it in the browser's `localStorage`.

### All other APIs (like tasks)

`SecurityConfig` runs only once at application startup. It defines the rules and arranges the filters in the chain, and it does not run on every request.

For each protected request, the Angular HTTP interceptor reads the token from `localStorage` and adds it to the request header as `Authorization: Bearer <token>`. The request reaches Tomcat and passes through the filters in this order: `CorsFilter`, then `JwtAuthFilter`, then `AuthorizationFilter`.

1. Inside `JwtAuthFilter.doFilterInternal()`, the token is read from the header and validated (signature and expiry) using `JwtService`.
2. The filter doesn't use the password. It extracts the email from the token, loads the user through `CustomUserDetailsService` to confirm the user still exists, and stores the authenticated user in the `SecurityContext`.
3. `AuthorizationFilter` checks whether the request is authenticated (the rule `anyRequest().authenticated()`).
4. If it is, the request continues to the `DispatcherServlet`, which sends it to the right controller such as `TaskController`, then `TaskService`, then the repository and the database.
5. The service checks ownership using the user's ID, so users only see and change their own tasks.

If the token is missing, invalid, or expired, the `SecurityContext` stays empty, `AuthorizationFilter` blocks the request, and the client receives a **401**. The Angular interceptor then clears the token and redirects to the login page.

### Token summary

The token is created by `JwtService`, triggered by `AuthService` at login. It is sent to the client in the response body and stored in the browser's `localStorage`. It is attached to every request in the `Authorization` header by the Angular interceptor and validated by `JwtAuthFilter` on the backend. The server keeps no copy. The token is removed from `localStorage` on logout.

## Configuration: JWT Secret Key

The JWT secret is **never committed to Git**. It is read from an environment variable named `JWT_SECRET`.

`application.properties`:

```properties
app.jwt.secret=${JWT_SECRET}
app.jwt.expiration-ms=86400000
```

### 1. Generate a secret (PowerShell)

```powershell
[Convert]::ToBase64String((1..32 | ForEach-Object { Get-Random -Maximum 256 }))
```

The result must be a valid Base64 string of at least 32 bytes (about 44 characters).

### 2. Set it: pick one option

**Option 1: permanent (stored for your Windows user)**

```powershell
setx JWT_SECRET "paste-your-generated-secret-here"
```

Close the window and open a **new** PowerShell, then check:

```powershell
echo $env:JWT_SECRET
```

If you run the app from VS Code, restart VS Code too so it picks up the new variable.

**Option 2: temporary (only for the current PowerShell window)**

Open PowerShell in the project folder and run:

```powershell
$env:JWT_SECRET="paste-your-generated-secret-here"
echo $env:JWT_SECRET
mvn spring-boot:run
```

The variable is gone when the window is closed, so set it again each time.

### Notes

- Use a different secret for local development and for production.
- On a hosting platform (Render, Railway, etc.), set `JWT_SECRET` in the platform's environment variable settings.
- If a secret is ever pushed to GitHub, generate a new one. Existing tokens then become invalid.

## Testing in Postman

1. **Register:** `POST http://localhost:8080/api/auth/register`

   ```json
   {
     "name": "Aruna",
     "email": "aruna@test.com",
     "password": "Test@12345"
   }
   ```

   Expect `201`. In the database, `password_hash` should start with `$2a$`.

2. **Login:** `POST http://localhost:8080/api/auth/login`

   ```json
   {
     "email": "aruna@test.com",
     "password": "Test@12345"
   }
   ```

   Expect `200` with a `token`. Copy the token.

3. **Call protected APIs:** in the request's **Authorization** tab choose **Bearer Token** and paste the token (don't type the word `Bearer`, Postman adds it).

4. **Create a task:** `POST http://localhost:8080/api/tasks`

   ```json
   {
     "title": "Finish JWT integration",
     "description": "Complete login and token flow",
     "status": "TODO",
     "priority": "HIGH",
     "dueDate": "2026-11-20",
     "categoryId": 1
   }
   ```

### Expected results

| Test | Expected |
|------|----------|
| Register a new user | 201 |
| Register the same email again | Error (duplicate email) |
| Login with correct credentials | 200 + token |
| Login with wrong password | 401 |
| `GET /api/tasks` without a token | 401 |
| `GET /api/tasks` with a valid token | 200 |
| `POST /api/tasks` with a valid token | 201 |
| Another user requests the first user's task | Should not be visible |

## Running Locally

1. Create a PostgreSQL database and set the connection in `application.properties`.
2. Set the `JWT_SECRET` environment variable (see above).
3. Run:

   ```powershell
   mvn spring-boot:run
   ```

4. The API is available at `http://localhost:8080`.

## Next Steps

- Fix `PUT /api/tasks/{id}` and `GET /api/tasks/{id}`
- Add `DELETE /api/tasks/{id}`
- Add a global exception handler for consistent error responses
- Connect the Angular login and register screens to these APIs
- Deployment



### 🐞 Bug Found While Testing Day 3 Frontend

While testing the Angular frontend, I logged in as a second user and noticed that user 2's dashboard showed user 1's tasks.

- **Cause:** `getAllTasks` looked up tasks with `findById(userId)`, which matches the **task id** instead of the **user id**. An earlier version also used `findAll()`, which returned every user's tasks.
- **Fix:** Moved tasks to per-user access in the repository and service:
  - `findByUserId(userId)` returns all tasks that belong to the logged-in user.
  - `findByIdAndUserId(id, userId)` returns a single task only if it belongs to that user.
- **Result:** Each user now sees only their own tasks. Verified by logging in as user 2, whose dashboard showed no tasks.


# Day 4 – Backend: Bug Fixes and Error Handling

**Date:** 16 Nov 2026 | **Focus:** make the task APIs correct and secure before building more features

## Summary

Fixed the broken `GET /tasks/{id}`, `PUT /tasks/{id}` and `DELETE /tasks/{id}` endpoints, and replaced fragile `Optional.get()` calls with proper exception handling so the API returns clean 404 responses instead of 500s.

## The Bug

All by-id endpoints go through one helper in `TaskController`. It was casting the repository result to `Tasks` and then calling `.get()`. `findByIdAndUserId` already returns an `Optional<Tasks>`, so the extra cast broke the call.

A second, hidden problem: `.get()` on an empty `Optional` throws `NoSuchElementException`, which Spring turns into a **500**. A missing task (or another user's task) should be a **404**.

## The Fix

```java
private Tasks findOwnedTask(Long taskId, Long userId) {
    return taskRepo.findByIdAndUserId(taskId, userId)
            .orElseThrow(() -> new TaskNotFoundException(taskId));
}
```

## Changes Made

- Fixed `findOwnedTask` (removed the cast, switched to `orElseThrow`)
- Added `TaskNotFoundException`
- Added `GlobalExceptionHandler` (`@RestControllerAdvice`) returning JSON errors:
  ```json
  { "error": "Task not found with id 99999" }
  ```
- Confirmed GET by id, PUT and DELETE all work end to end

## Security Decision

Another user's task returns **404, not 403**. The API never confirms that a task id exists for someone else.

## Tested in Postman

| Scenario | Expected | Result |
|---|---|---|
| GET own task by id | 200 | ✅ |
| PUT own task | 200 | ✅ |
| DELETE own task | 200/204 | ✅ |
| GET/PUT/DELETE another user's task | 404 | ✅ |
| Non-existent id | 404 | ✅ |
| No token | 401 | ✅ |

> Tick or edit these rows to match what you actually tested.

## What I Learned

- A small type-cast mistake can look like a big architectural problem. Read the stack trace first.
- `Optional.get()` hides a 500. Use `orElseThrow`.
- `@RestControllerAdvice` keeps error responses consistent across all controllers.
- Return DTOs, not entities, from controllers.

# TaskFlow Backend: Deployment

Spring Boot API deployed with Docker on **Render**, connected to a **Neon** PostgreSQL database.

- API health check: https://taskflow-backend-dar5.onrender.com/actuator/health
- Live app: https://taskfloooow.netlify.app

## How I deployed it

### 1. Database on Neon
1. Created a Neon project in **AWS Asia Pacific 1 (Singapore)**.
2. Copied the connection string and split it into three values for Spring Boot:
   - `DATABASE_URL`: `jdbc:postgresql://<host>/<database>?sslmode=require`
   - `DATABASE_USERNAME`
   - `DATABASE_PASSWORD`
3. Left the database empty. Flyway creates the tables on the first start of the backend.

### 2. Dockerfile
Added a multi-stage `Dockerfile` in the project root. The first stage builds the jar with Maven and the second stage runs it on a slim Java 21 image.

### 3. Push to GitHub
Committed the code and the `Dockerfile`. No secrets are in the repo: the properties file contains only placeholders, and local values live in a git-ignored `application-local.properties`.

### 4. Create the web service on Render
1. Render, **New**, **Web Service**, and selected this repository.
2. Runtime: **Docker**
3. Region: **Singapore**
4. Instance type: **Free**
5. Health check path: `/actuator/health`

### 5. Environment variables on Render

| Key | Value |
|---|---|
| `DATABASE_URL` | JDBC URL from Neon |
| `DATABASE_USERNAME` | Neon user |
| `DATABASE_PASSWORD` | Neon password |
| `JWT_SECRET` | New random secret generated for production |
| `SPRING_PROFILES_ACTIVE` | `prod` |
| `CORS_ALLOWED_ORIGINS` | Netlify frontend URL |

### 6. Deploy and verify
Render builds the image and starts the service. Opening `/actuator/health` returns `{"status":"UP"}`, and the logs show Flyway creating the schema.

### 7. Connect the frontend
After the frontend was live on Netlify, I set `CORS_ALLOWED_ORIGINS` to its URL. The CORS configuration reads this variable, so changing it and redeploying is all that is needed.

> The free Render instance sleeps when idle, so the first request after a break can take 30 to 60 seconds.