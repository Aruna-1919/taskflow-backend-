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