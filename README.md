e# ✈️ AeroBook — Flight Ticket Booking System

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red?style=for-the-badge&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

*A modern, secure, and efficient flight booking system built with Spring Boot*

</div>

---

## 📋 Table of Contents

- [🌟 Overview](#-overview)
- [✨ Key Features](#-key-features)
- [🛠️ Technology Stack](#️-technology-stack)
- [🏗️ System Architecture](#️-system-architecture)
- [🚀 Quick Start](#-quick-start)
- [📡 API Endpoints](#-api-endpoints)
- [🔐 Security](#-security)
- [⚙️ Background Tasks](#️-background-tasks)
- [🗄️ Database Setup](#️-database-setup)
- [📖 API Documentation](#-api-documentation)
- [🧪 Testing](#-testing)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)

---

## 🌟 Overview

**AeroBook** is a comprehensive flight ticket booking system designed to handle real-time flight searches, seat reservations, and booking confirmations. The system implements advanced features like optimistic locking to prevent race conditions and automated background jobs to manage seat holds efficiently.

### 🎯 Core Functionality

- **Real-time Flight Search**: Search available flights with live pricing and seat availability
- **Smart Seat Holding**: Temporarily reserve seats for 10 minutes to ensure fair booking
- **Secure Booking Process**: Complete booking flow with simulated payment processing
- **Automated Cleanup**: Background jobs automatically release expired seat holds
- **User Authentication**: Secure user management with JWT-based authentication

---

## ✨ Key Features

### 🔍 **Flight Search & Discovery**
- Search flights by departure/arrival airports (IATA codes) and travel dates
- Real-time seat availability and minimum pricing information
- Comprehensive flight details including schedules and aircraft information

### 💺 **Intelligent Seat Management**
- **10-minute hold system** prevents booking conflicts
- **Optimistic locking** ensures data consistency during concurrent bookings
- **Automatic expiration** of unused seat holds via scheduled background jobs
- Support for different seat types and pricing tiers

### 🔒 **Secure Booking Process**
- Multi-step booking workflow: Search → Hold → Confirm
- Simulated payment processing integration
- Booking status tracking and management
- User-specific booking history

### 🛡️ **Enterprise Security**
- JWT-based authentication system
- Role-based access control (USER role)
- Secure password handling with Spring Security
- Protected API endpoints with proper authorization

### ⚡ **Performance & Reliability**
- Scheduled background tasks for system maintenance
- Database optimization with JPA projections
- Efficient query handling for large datasets
- Comprehensive error handling and validation

---

## 🛠️ Technology Stack

### **Backend Framework**
- **Java 17** - Modern LTS version with enhanced performance
- **Spring Boot 3.5.3** - Enterprise-grade application framework
- **Spring Data JPA** - Simplified data access layer
- **Spring Security** - Comprehensive security framework
- **Spring Validation** - Request validation and data integrity

### **Database & Persistence**
- **PostgreSQL** - Robust relational database
- **Hibernate ORM** - Object-relational mapping
- **Connection Pooling** - Optimized database connections

### **Development Tools**
- **Lombok** - Reduced boilerplate code
- **Maven** - Dependency management and build automation
- **Spring Boot DevTools** - Enhanced development experience

### **API & Documentation**
- **SpringDoc OpenAPI** - Automated API documentation
- **Swagger UI** - Interactive API testing interface
- **JWT (JSON Web Tokens)** - Stateless authentication

---

## 🏗️ System Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Frontend/     │    │   Spring Boot   │    │   PostgreSQL    │
│   API Client    │◄──►│   Application   │◄──►│   Database      │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              │
                              ▼
                    ┌─────────────────┐
                    │  Background     │
                    │  Scheduler      │
                    │  (Seat Cleanup) │
                    └─────────────────┘
```

### **Core Components**

- **Controllers**: RESTful API endpoints for client interaction
- **Services**: Business logic implementation and transaction management
- **Repositories**: Data access layer with custom queries
- **Entities**: JPA entities representing database tables
- **DTOs**: Data transfer objects for API communication
- **Security**: JWT authentication and authorization filters
- **Scheduler**: Background tasks for system maintenance

---

## 🚀 Quick Start

### **Prerequisites**

Ensure you have the following installed:
- ☕ **Java 17** or higher
- 🐘 **PostgreSQL 12+**
- 📦 **Maven 3.6+**
- 🔧 **Git**

### **Installation Steps**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/MuminjonovAsrorbek/AeroBook.git
   cd AeroBook
   ```

2. **Database Setup**
   ```bash
   # Create PostgreSQL database
   createdb aerobook
   
   # Or using psql
   psql -U postgres -c "CREATE DATABASE aerobook;"
   ```

3. **Configure Database Connection**
   
   Update `src/main/resources/application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/aerobook
       username: your_username
       password: your_password
   ```

4. **Build the Project**
   ```bash
   ./mvnw clean compile
   ```

5. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

6. **Verify Installation**
   
   The application will start on `http://localhost:8080`
   
   Access Swagger UI: `http://localhost:8080/swagger-ui.html`

### **Alternative: Using Maven Wrapper (Recommended)**

```bash
# For Unix/Linux/macOS
./mvnw spring-boot:run

# For Windows
mvnw.cmd spring-boot:run
```

---

## 📡 API Endpoints

### **🔐 Authentication**
```http
POST /api/auth/login          # User authentication
POST /api/auth/register       # User registration
```

### **✈️ Flight Operations**
```http
GET  /api/flights/search      # Search available flights
     ?fromIata=JFK&toIata=LAX&date=2024-12-25

GET  /api/scheduled-flights/{flightId}/seats  # Get available seats
```

### **🎫 Booking Management**
```http
POST /api/bookings/hold       # Hold selected seats (10-minute expiration)
POST /api/bookings/confirm    # Confirm booking and process payment
GET  /api/bookings/user       # Get user's booking history
```

### **👤 User Management**
```http
GET  /api/users/profile       # Get user profile
PUT  /api/users/profile       # Update user information
```

### **📊 System Information**
```http
GET  /api/health              # Application health check
GET  /swagger-ui.html         # API documentation
```

---

## 🔐 Security

### **Authentication System**
- **JWT-based authentication** for stateless security
- **Secure password hashing** using Spring Security
- **Token expiration** and refresh mechanism
- **Role-based access control** (USER role)

### **API Security**
- All endpoints require authentication except registration/login
- **CORS configuration** for cross-origin requests
- **Input validation** on all request parameters
- **SQL injection prevention** through JPA/Hibernate

### **Default User Roles**
- **USER**: Standard user with booking capabilities
- Future roles: ADMIN, AGENT (for system expansion)

---

## ⚙️ Background Tasks

### **Automated Seat Hold Cleanup**

The system runs a **scheduled job every minute** to:

- 🔍 **Identify expired holds** (older than 10 minutes)
- 🧹 **Release held seats** back to available inventory
- 📊 **Update booking statuses** for expired holds
- 🗑️ **Clean up temporary data** to maintain performance

```java
@Scheduled(fixedRate = 60000) // Runs every 60 seconds
public void releaseExpiredHolds() {
    // Automatic cleanup logic
}
```

This ensures:
- **Fair seat allocation** among users
- **Optimal system performance** by preventing data buildup
- **Accurate availability** information for new searches

---

## 🗄️ Database Setup

### **PostgreSQL Configuration**

1. **Install PostgreSQL**
   ```bash
   # Ubuntu/Debian
   sudo apt-get install postgresql postgresql-contrib
   
   # macOS (using Homebrew)
   brew install postgresql
   
   # Windows: Download from postgresql.org
   ```

2. **Create Database and User**
   ```sql
   -- Connect to PostgreSQL
   psql -U postgres
   
   -- Create database
   CREATE DATABASE aerobook;
   
   -- Create user (optional)
   CREATE USER aerobook_user WITH PASSWORD 'secure_password';
   GRANT ALL PRIVILEGES ON DATABASE aerobook TO aerobook_user;
   ```

3. **Database Schema**
   
   The application uses **Hibernate DDL auto-update**, so tables will be created automatically on first run.

### **Key Database Tables**

- **users** - User account information
- **airports** - Airport master data (IATA codes, names, locations)
- **flights** - Flight route definitions
- **scheduled_flights** - Specific flight instances with dates/times
- **seats** - Aircraft seat configurations
- **flight_seats** - Seat availability for specific flights
- **bookings** - User booking records and status

---

## 📖 API Documentation

### **Interactive Documentation**

Once the application is running, access the **Swagger UI** at:

🌐 **http://localhost:8080/swagger-ui.html**

### **API Documentation Features**

- 📋 **Complete endpoint documentation** with request/response schemas
- 🧪 **Interactive testing interface** - test APIs directly from browser
- 📝 **Request/response examples** for all endpoints
- 🔐 **Authentication testing** with JWT token support
- 📊 **Model definitions** for all DTOs and entities

### **Sample API Requests**

**Search Flights:**
```json
GET /api/flights/search?fromIata=NYC&toIata=LAX&date=2024-12-25

Response:
{
  "flights": [
    {
      "flightId": "FL001",
      "airline": "AeroLine",
      "departure": "2024-12-25T08:00:00",
      "arrival": "2024-12-25T11:30:00",
      "availableSeats": 45,
      "minPrice": 299.99
    }
  ]
}
```

**Hold Seats:**
```json
POST /api/bookings/hold
{
  "flightId": "FL001",
  "seatIds": ["1A", "1B"],
  "userId": "user123"
}

Response:
{
  "holdId": "HOLD_789",
  "expiresAt": "2024-12-25T08:10:00",
  "status": "HELD"
}
```

---

## 🧪 Testing

### **Run Tests**

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=BookingServiceTest

# Run tests with coverage
./mvnw test jacoco:report
```

### **Test Categories**

- **Unit Tests**: Service layer business logic
- **Integration Tests**: Repository and database operations
- **Security Tests**: Authentication and authorization
- **API Tests**: Controller endpoint testing

### **Test Database**

Tests use an **in-memory H2 database** for isolation and speed.
