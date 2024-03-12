
# Login Application

## Overview
This project is a Java-based web application designed for user authentication and management. Built with Spring Boot, it features a custom login mechanism, user management capabilities, and database integration.

## Features
- User authentication and session management
- Role-based access control
- CRUD operations for user management
- Database health check
- Responsive HTML templates for the user interface
- Secure password handling with custom encoding

## Technology Stack
- **Backend:** Java, Spring Boot
- **Frontend:** HTML, CSS (assumed from the context, please confirm or amend)
- **Database:** Configurable via `application.properties`, SQL scripts for database setup
- **Build tool:** Gradle

## Getting Started

### Prerequisites
- JDK 17 or newer
- Gradle (wrapper included)

### Setting Up the Database
1. Create your database schema using the `user.sql` script found in `src/main/resources`.
2. Configure your database connection details in `src/main/resources/application.properties`.

### Running the Application
1. Clone this repository.
2. Navigate to the project directory.
3. Use the Gradle wrapper to build and run the application:
   ```
   ./gradlew build
   ./gradlew bootRun
   ```
4. Access the application at `http://localhost:8080`.

## Project Structure
- `src/main/java/com/example/login`: Main application package.
    - `config/`: Security and encoder configurations. The `CustomPasswordEncoder` and `Encoder` classes provide secure password encoding mechanisms, ensuring user passwords are safely managed within the application. **(required by assignment)**
    - `controller/`: Web controllers.
    - `model/`: Entity definitions.
    - `repository/`: Data access layers.
    - `service/`: Service layer.
- `src/main/resources/`: Application resources.
    - `application.properties`: Application configurations.
    - `templates/`: HTML templates for the UI.
    - `user.sql`: SQL script for initial database setup.
- `src/test/`: Unit and integration tests.


## For Testing purpose
Manager Account 
- `username`: manager1 `password`: HELLO WORLD
- `username`: manager2 `password`: HELLO WORLD

Normal Account 
- `username`: user1 `password`: HELLO WORLD
- `username`: user2 `password`: HELLO WORLD
- `username`: user3 `password`: HELLO WORLD

