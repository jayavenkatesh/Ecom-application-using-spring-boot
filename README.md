# Ecom-application-using-spring-boot

This project is the backend of an eCommerce application developed using the Spring Framework, adhering to the MVC (Model-View-Controller) architecture. It is designed to handle client requests efficiently, manage business logic, and interface with a PostgreSQL database.

Technologies Used:
Spring Boot
Spring Data JPA
PostgreSQL
Maven


Key Features:
MVC Architecture: The project follows the MVC pattern to separate concerns, improving scalability and maintainability.
Spring Framework: Utilizes the power of the Spring Framework for handling dependency injection, request mapping, and service management.
PostgreSQL Integration: PostgreSQL is used as the database to store and retrieve data.
Port: The application runs on https://localhost:8080.


Architecture Overview:

Client Request: The user interacts with the frontend application, sending HTTP requests to the server.
Controller: Spring MVC routes the request based on predefined mappings to an appropriate controller class. The controller is responsible for handling the request's logic by delegating tasks to the service layer.
Service Layer: This layer encapsulates core business logic, such as product management, user authentication, and order processing. It interacts with the repository layer and may perform validation, rule enforcement, and other essential operations.
Repository Layer: This layer acts as the bridge between the service layer and the database. It utilizes Spring Data JPA or JDBC to perform CRUD (Create, Read, Update, Delete) operations on data stored in PostgreSQL.


Benefits:

Modular Design: Clear separation of concerns facilitates easier maintenance, testing, and independent development.
Flexibility: The MVC pattern allows for customization of individual layers without affecting others.
Database Agnostics: Spring Data provides an abstraction layer, enabling easy switching to other databases if needed.
Scalability: The modular architecture promotes horizontal scaling to accommodate increased traffic.

