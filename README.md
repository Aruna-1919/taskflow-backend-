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

