# Transport Connect AI - Project Context

## Project Goal

Build a production-grade Transport Management System (TMS) using Java 23, Spring Boot 4, PostgreSQL, Redis, Kafka, Flyway, JWT Security, OpenAPI, and Clean Architecture.

The project is being built primarily for:

1. Senior Java Developer Interviews
2. Product Development Learning
3. Demonstrating Enterprise Architecture Skills
4. Understanding Distributed Systems Concepts

---

# Current Technology Stack

Backend:

* Java 23
* Spring Boot 4
* Spring Security
* Spring Data JPA
* Hibernate
* Flyway
* PostgreSQL
* Redis
* Kafka
* JWT Authentication
* Swagger/OpenAPI

Infrastructure:

* Docker (planned)
* Kubernetes (planned)
* AWS Deployment (planned)

---

# Architecture Style

Clean Architecture

Structure:

com.transport.tms

```
identity/
driver/
fleet/
load/
shipmentTracking/
```

Each module contains:

domain
application
infrastructure
api

Example:

driver

```
domain
    Driver.java
    DriverRepository.java

application
    CreateDriverService.java

infrastructure
    DriverJpaRepository.java
    DriverEntity.java

api
    DriverController.java
```

---

# Completed Modules

## Identity Module

Implemented:

* User Entity
* UserJpaRepository
* JWT Authentication
* JWT Filter
* Security Configuration
* UserDetailsService

Purpose:
Authentication and authorization.

---

## Driver Module

Implemented:

Driver Entity

Fields:

* id
* fullName
* licenseNumber
* phoneNumber
* status

Repository:

* DriverJpaRepository

Services:

* CreateDriverService

API:

* DriverController

Completed CRUD:

* Create Driver

---

## Fleet Module

Implemented:

Truck Entity

Fields:

* id
* truckNumber
* truckType
* capacity
* status

Repository:

* TruckJpaRepository

Services:

* CreateTruckService

API:

* TruckController

Completed CRUD:

* Create Truck

---

## Load Module

Implemented:

Load Entity

Fields:

* id
* pickupLocation
* deliveryLocation
* loadWeight
* status

Repository:

* LoadJpaRepository

Services:

* CreateLoadService

API:

* LoadController

Completed CRUD:

* Create Load

---

## Shipment Tracking Module

Implemented:

TrackingLocation Entity

Fields:

* id
* truckId
* latitude
* longitude
* timestamp

Repository:

TrackingLocationJpaRepository

Flyway Migration:

V8__create_tracking_locations.sql

Current Status:
Application starts successfully.

---

# Next Development Task

Build Real-Time Tracking APIs

## Service 1

UpdateTruckLocationService

Responsibilities:

* Validate truck exists
* Save location
* Publish tracking event

Input:

truckId
latitude
longitude

Output:

TrackingLocation

---

## Service 2

GetTruckLocationService

Responsibilities:

* Fetch latest location

Input:

truckId

Output:

Latest truck location

---

## Controller

TrackingController

Endpoints:

POST
/api/tracking/update

GET
/api/tracking/latest/{truckId}

---

# Future Roadmap

Phase 1

* Tracking APIs

Phase 2

* Redis Cache

Phase 3

* Kafka Events

Phase 4

* Load Assignment Engine

Phase 5

* Route Optimization

Phase 6

* Driver Mobile APIs

Phase 7

* Analytics Dashboard

Phase 8

* Docker

Phase 9

* Kubernetes

Phase 10

* AWS Deployment

---

# Important Interview Topics

This project should demonstrate:

Spring Boot
Spring Security
JWT
JPA
Hibernate
Flyway
PostgreSQL
Redis
Kafka
Clean Architecture
Microservice Design
Caching
Distributed Systems
Docker
Kubernetes
AWS

---

# Common Problems Faced During Development

## Flyway Migration Issue

Problem:
Migration executed but Hibernate failed validation.

Error:
Schema validation: missing table tracking_location

Root Cause:
Table name mismatch between migration and entity.

Solution:
Align entity @Table name and Flyway migration table name.

---

## Repository Scanning Issue

Problem:
Spring Data Redis attempted to scan JPA repositories.

Solution:
Use proper package separation and repository configuration.

---

## EntityManagerFactory Failure

Problem:
Bean creation failure due to schema validation errors.

Solution:
Fix migration mismatch and restart application.

---

# Interview Questions Expected

1. Explain Clean Architecture.

2. Why separate Domain and Infrastructure?

3. Difference between JPA Repository and Domain Repository?

4. How JWT Authentication works internally?

5. How Spring Security Filter Chain works?

6. What is Dependency Injection?

7. Explain Spring IoC Container.

8. Bean Lifecycle in Spring?

9. Singleton vs Prototype Scope?

10. Why Flyway instead of Hibernate auto-ddl?

11. Hibernate First Level Cache?

12. Hibernate Second Level Cache?

13. How Kafka guarantees delivery?

14. How Redis improves performance?

15. What happens when a REST request hits Spring Boot?

16. Explain DispatcherServlet.

17. Explain Transaction Management.

18. Difference between @Component, @Service, @Repository.

19. Explain Circular Dependency and resolution.

20. Explain AOP and Proxy Pattern.

---

Current Status:

Application starts successfully.
Ready to implement Tracking APIs.
