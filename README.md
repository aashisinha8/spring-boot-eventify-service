# Eventify – Role-Based Event Management Backend

A production-style backend service built with Java and Spring Boot for managing events and users with secure, role-based access control.

---

## Overview

Eventify is a RESTful backend system that supports three user roles — **ADMIN**, **ORGANIZER**, and **PARTICIPANT** — each with distinct permissions across user and event management workflows. Built to demonstrate clean layered architecture, JWT-based security, and document-based persistence with MongoDB.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | MongoDB (Spring Data) |
| Build Tool | Maven |
| API Testing | Postman |

---

## Features

- JWT-based stateless authentication
- Role-based access control (ADMIN / ORGANIZER / PARTICIPANT)
- Full event lifecycle management (create, update, delete, view)
- User registration and login
- Centralized exception handling with meaningful HTTP status codes
- Input validation on all endpoints
- Structured layered architecture: Controller → Service → Repository

---

## Project Structure
src/
├── controller/       # REST API endpoints
├── service/          # Business logic
├── repository/       # MongoDB data access
├── model/            # Domain entities (User, Event)
├── security/         # JWT filter, security config
├── dto/              # Request/response objects
└── exception/        # Global exception handler

---

## Getting Started

### Prerequisites
- Java 17+
- MongoDB running locally on port `27017`
- Maven 3.8+

### Run Locally

```bash
# Clone the repository
git clone https://github.com/aashisinha8/spring-boot-eventify-service.git
cd spring-boot-eventify-service

# Start the application
./mvnw spring-boot:run
```

The service starts on `http://localhost:8080`

---

## API Reference

### Auth

| Method | Endpoint | Role | Description |
|---|---|---|---|
| POST | `/users` | Public | Register a new user |
| POST | `/auth/login` | Public | Login and receive JWT token |

### Events

| Method | Endpoint | Role | Description |
|---|---|---|---|
| POST | `/events` | ADMIN, ORGANIZER | Create a new event |
| GET | `/events` | ALL | View all events |
| PUT | `/events/{id}` | ADMIN, ORGANIZER | Update an event |
| DELETE | `/events/{id}` | ADMIN | Delete an event |

### Admin

| Method | Endpoint | Role | Description |
|---|---|---|---|
| GET | `/users` | ADMIN | View all users |
| DELETE | `/users/{id}` | ADMIN | Remove a user |

### Health

| Method | Endpoint | Description |
|---|---|---|
| GET | `/health` | Service health check |

---

## Security Model

Authentication uses **JWT tokens** passed as Bearer tokens in the `Authorization` header.

Authorization: Bearer <your_token>

Role permissions are enforced at the endpoint level via Spring Security's filter chain:

- **ADMIN** – full access across users and events
- **ORGANIZER** – can create and manage their own events
- **PARTICIPANT** – read-only access to events

---

## Author
**Aayushi Sinha**  
[LinkedIn](https://linkedin.com/in/aayushi-sinha-171819180) | [GitHub](https://github.com/aashisinha8)
