# Cloud Store Management

## Design

Store Management system within a microservices architecture produced in an agile workflow environment.

## Tech Stack & Dependencies
 * Java 8
 * Spring Frameworks, Dependencies & Spring Boot 
 * MySQL
 * Maven 

### Cloud-Native Design

The design incorporates many elements of a modern cloud-native architecture including:

* Configuration Server
* Service Registry
* Queues
* Circuit Breaker
* Caching
* Micoservices
* Backend for Frontend (BFF) edge services

---

## Features and Functional Requirements

### Configuration Server

##### Port

This service runs on port 9999.

### Service Registry

##### Port

This service runs on port 8761.

---

## Architecture

### Configuration Server

All services in the system must use the Configuration Server for all of their configuration files.

### Service Registry

All backing services registerd with the Service Registry through Netflix Eureka. 

### Interaction with Backing Services

Communication to backing services from the Retail API and Admin API web services done using Open Feign clients in a Service Layer component.

### Database Interaction

Primary Database used with MYSQL, written with JDBC.

### Caching

Spring Caching support with caches done in the Backend services.

### Circuit Breaker
Circuit Breakers set for fallback measures with Netflix Hystrix.

### Error Handling

* Implemented ControllerAdvice to handle exceptions and return propery HTTP status codes and data when exception occur. This includes handling all violoations of business rules.
* Uses JSR 303 validation.

### Documentation

Your REST APIs must be documented with Swagger. [YAML file] (https://github.com/juhuyoon/Cloud-Store-Management/blob/master/U2Capstone.yaml)

### Contributions
1) Barbara Hernandez [Github](https://github.com/BarbaraHernandez)
2) Richard Fenix [Github](https://github.com/rfenix3)
