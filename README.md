# Eventify - Smart Event Management System

## Overview

Eventify is a Spring Boot based event management platform that enables organizers to create and manage events while participants can register and receive notifications.

The application uses JWT-based authentication, MongoDB for persistence, Docker for containerization, and Apache Kafka for asynchronous event-driven notifications.

---

## Features

### Authentication & Authorization

* User Registration
* User Login
* JWT Authentication
* Role-Based Access Control

  * ADMIN
  * ORGANIZER
  * PARTICIPANT

### Event Management

* Create Event
* View Events
* Delete Events
* Organizer-specific Event Management

### Notification System

* Kafka-based Event Notifications
* Asynchronous Event Processing
* User-specific Notifications
* Mark Notifications as Read

### Infrastructure

* MongoDB
* Docker
* Apache Kafka
* Zookeeper

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT
* MongoDB
* Apache Kafka
* Docker
* Maven

---

## Event-Driven Notification Flow

Event Created
→ Kafka Producer
→ event-created Topic
→ Kafka Consumer
→ Notification Service
→ MongoDB Notifications Collection

---

## APIs

### Authentication

POST /auth/register

POST /auth/login

### Events

POST /events

GET /events

DELETE /events/{id}

### Notifications

GET /notifications/{userId}

PUT /notifications/{notificationId}/read

---

## Future Enhancements

* Participant Event Registration
* Organizer Notification on Registration
* Email Notifications
* Microservice Architecture
* Docker Compose for Full Deployment
* Redis Caching
