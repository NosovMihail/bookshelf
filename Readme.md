## Project Bookshelf

This project is test task.

### Technologies Used

- Hibernate
- Spring Boot
- H2 Database
- Java 16
- Maven

### Installation and Setup

1. Clone the project repository to your computer.
2. Make sure you have Java 16 and Maven installed.
3. Open a terminal or command prompt and navigate to the project directory.
4. Build the project by running the following command: `mvn clean install`.
5. Start the application by running the following command: `mvn spring-boot:run`.

### Usage

Endpoint is available at `http://127.0.0.1:8080/books` and accepts the optional 'author' and 'genre' parameters. Examples:
`http://127.0.0.1:8080/books?author=mar`
`http://127.0.0.1:8080/books?author=Jorge&genre=horror`

### Database Configuration

The project is configured to use an H2 in-memory database by default. The database connection settings can be found in the `hibernate.cfg.xml` file.
