# Employee-Department Management System



## A simple Spring Boot application for managing employees and departments. 
## It demonstrates a one-to-many relationship between employees and departments using MySQL for data storage.

## Table of Contents
- Features
- Technologies Used
- Prerequisites
- Installation
- Usage
- API Documentation
- Contributing

## Features
- Employee Management: Add, update, and delete employee records.
- Department Management: Manage department records.
- One-to-Many Relationship: Employees are associated with one department.
- JSP Frontend: User-friendly JSP pages for interacting with the application.
- Database: Data stored in MySQL with two tables—employee and department

# Technologies Used
- Framework: Spring Boot (version 3.4.0)
- Frontend: JSP
- Database: MySQL
- Build Tool: Maven
- Other Libraries: Spring Data JPA, Hibernate, jsp.

# Getting Started
## Prerequisites

- Java 17
- Maven
- Git
- MySQL
- mapstruts

# Installation
## Clone the repository:
git clone https://github.com/mohamed-daif55/management-system.git

# Configure application.properties :
- spring.application.name=Management-System
- server.port=9090
- 
- spring.datasource.url=jdbc:mysql://localhost:3306/management_system
- spring.datasource.username=root
- spring.datasource.password=admin
- spring.jpa.show-sql=true
- spring.jpa.properties.hibernate.format_sql=true

- springdoc.api-docs.path=/api-docs
- springdoc.swagger-ui.path=/swagger-ui.html
- springdoc.info.title=Sample API springdoc.info.version=1.0
- springdoc.info.description=API documentation for Sample Project

- spring.mvc.view.prefix=/WEB-INF/jsp/
- spring.mvc.view.suffix=.jsp

## Build the project:
- mvn clean install

## Run the application:
- java -jar Management-System-0.0.1-SNAPSHOT.war

# Usage
- Access the application at http://localhost:9090.

- Use tools like Swagger to generate and view API documentation. Access the Swagger UI :
- localhost:9090/swagger-ui/index.html

