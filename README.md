# Spring Microservices Template

This template repository demonstrates a fundamental microservices architecture built with Spring Boot, featuring multiple services that communicate synchronously via HTTP and asynchronously via RabbitMQ, and persist data in different databases.

## Services Overview

### 1. `product-service`
A RESTful service to manage products.

- **Database:** PostgreSQL
- **Key Features:**
  - CRUD operations for products
  - REST API endpoints using Spring Web
  - Persistence with Spring Data JPA
  - Database migrations with Flyway

### 2. `order-service`
Responsible for creating and storing orders, validating product existence by calling `product-service`, and publishing order creation notifications to RabbitMQ.

- **Database:** MongoDB
- **Key Features:**
  - Order creation and persistence using Spring Data MongoDB
  - Calls `product-service` REST API to verify product data before creating orders
  - Publishes `OrderNotification` events asynchronously to RabbitMQ (`order.exchange`, routing key `order.created`)
 
### 3. `notification-service`
Consumes messages from RabbitMQ and handles order notifications.

- **Queue:** `order.notifications`
- **Key Features:**
  - Listens for `OrderNotification` events via RabbitMQ
  - Processes incoming messages (simulates handling by logging notifications to the console)
  - Configured with `@RabbitListener`
 
## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Data JPA / MongoDB
- RabbitMQ (via Spring AMQP)
- PostgreSQL
- MongoDB
- Flyway (for DB migrations)
- Docker & Docker Compose (optional for local setup)

## Running the Project with Docker

### Docker Files
- `docker/docker-compose.yaml`
  
  Runs only infrastructure services: PostgreSQL, MongoDB, RabbitMQ

- `docker/docker-compose-full.yaml`

  Runs all microservices (`product-service`, `order-service`, `notification-service`) along with infrastructure

### Build Service Images

Before running the full environment, navigate to each service folder and build the Docker image:
```bash
cd product-service
mvn spring-boot:build-image

cd ../order-service
mvn spring-boot:build-image

cd ../notification-service
mvn spring-boot:build-image
```

Make sure you have Docker, Java 21, and Maven installed and running.

### Start Infrastructure Only

Navigate to `docker` folder and run:

```bash
docker compose up
```

To stop and remove containers:
```bash
docker compose down
```

### Start Full System (All Services)

Navigate to `docker` folder and run:

```bash
docker compose -f docker-compose-full.yaml up
```

To stop and remove all containers:
```bash
docker compose -f docker-compose-full.yaml down
```

## Using the Template Repository

1. Click "Use this template" button on GitHub to create a new repository from this template.
2. Clone your newly created repository:
```sh
git clone https://github.com/nedim-hairlahovic/your-repo.git
```

