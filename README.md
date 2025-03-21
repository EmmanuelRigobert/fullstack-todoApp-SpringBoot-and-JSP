My todoapi project is a web application for managing a to-do list. It is implemented using the following technologies:  

Technologies Used:

    Java: The primary programming language used for the application.
    Spring Boot: A framework used to create stand-alone, production-grade Spring-based applications.
    Spring MVC: A framework used to build web applications with a Model-View-Controller architecture.
    Spring Security: Used for authentication and authorization.
    Spring Data JPA: Used for data access and ORM (Object-Relational Mapping).
    H2 Database: An in-memory database used for development and testing.
    Maven: A build automation tool used for managing project dependencies and building the project.
    JSP (Jakarta Server Pages): Used for rendering the views (user interface).
    Jakarta Validation: Used for validating user input.

Key Components and Features:

Todo Entity:  
    Represents a to-do item with fields such as id, username, description, done, and dateline.

Controllers:  
    TodoController: Handles HTTP requests for managing to-do items using a service layer.
    TodoControllerJpa: Handles HTTP requests for managing to-do items using Spring Data JPA.
    
Service Layer:  
    TodoService: Provides business logic for managing to-do items.
    
Repository Layer:  
    TodoRepository: An interface extending JpaRepository for CRUD operations on the Todo entity.
    
Views:  
    JSP files located in src/main/resources/META-INF/resources/WEB-INF/jsp/ for rendering the user interface.
    
Security:  
    Authentication and authorization are managed using Spring Security.
    
Configuration:
    application.properties: Configuration file for setting up the application, including database connection, logging, and view resolver settings.
    
