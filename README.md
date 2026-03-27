# 🚗 Car Rental API

REST API for managing a car rental system.

Built with **Spring Boot 4**, **Java 21**, and **JDBC (JdbcClient)**.

---

## 🧠 Overview

This project provides basic CRUD operations for a car rental domain, including:

- Cars
- Customers
- Rentals

The focus is on **understanding backend fundamentals**, especially **SQL and database interaction**.

---

## ⚙️ Tech Stack

- Java 21
- Spring Boot 4
- Spring Web (REST)
- Spring JDBC (JdbcClient)
- H2 Database (in-memory)
- Lombok

---

## 🧩 Architecture

Layered architecture:

- **Controller** → handles HTTP
- **Service** → business logic
- **Repository** → SQL (JdbcClient)
- **DTOs** → request/response validation
- **Exception Handler** → centralized error handling

---

## 🚀 Features

### Cars

- CRUD operations
- Pagination support

### Customers

- CRUD operations
- Data validation

### Rentals

- Create rentals with business logic (date + price calculation)
- Validation using `@Valid`
- DTO-based input

---

## 🧪 Validation & Errors

- Bean Validation (`@Valid`)
- Custom error responses:
  ```json
  {
    "error": "Validation failed",
    "details": ["field X is required"]
  }
  ```
- Global exception handling:
    - Resource not found
    - Validation errors

---

## 🧩 Why JDBC (instead of JPA)?

This project uses **Spring JDBC (JdbcClient)** on purpose:

- To **better understand SQL**
- To have **full control over queries**
- To learn how data is actually fetched and mapped

This helps build a strong foundation before using abstractions like JPA/Hibernate.

---

## 🧪 Database

- H2 in-memory
- Auto-loaded with `data.sql`

---

## ▶️ Running

```
./mvnw spring-boot:run
```

H2 Console:

```
http://localhost:8080/h2-console
```
