# 🚀 TaskFlow — Minimal Task Management System

TaskFlow is a **production-ready task management backend** built with **Java Spring Boot**, following **Clean Architecture principles**. It supports user authentication, project management, and task tracking with full Dockerized infrastructure.

---

# 🧱 Features

### 🔐 Authentication

* Register & login
* JWT-based authentication (24h expiry)
* BCrypt password hashing (cost ≥ 12)

### 📁 Projects

* Create, update, delete projects
* List projects owned or participated in
* Ownership-based access control

### ✅ Tasks

* Create, update, delete tasks
* Assign tasks to users
* Filter by status and assignee
* Status: `todo | in_progress | done`
* Priority: `low | medium | high`

### ⚙️ Infrastructure

* PostgreSQL database
* Flyway migrations (schema + seed)
* Dockerized setup (one command run)
* Structured logging
* Graceful shutdown

---

# 🏗️ Architecture

This project follows **Clean Architecture (Hexagonal)**:

```
domain/           → Business models & interfaces
application/      → Use cases (services, DTOs)
infrastructure/   → DB, security, external systems
interfaces/       → REST controllers & exception handling
config/           → Security, JWT, app config
```

### Key Principles

* No framework code in domain
* Dependency inversion (interfaces → implementations)
* Clear separation of concerns
* Highly testable design

---

# 📦 Tech Stack

* Java 21
* Spring Boot 3
* Spring Security (JWT)
* PostgreSQL
* Flyway (migrations)
* Docker & Docker Compose
* Lombok
* MapStruct (optional mapping)

---

# ⚙️ Setup & Run

## 1. Clone the repo

```bash
git clone <your-repo-url>
cd taskflow
```

---

## 2. Setup environment

```bash
cp .env.example .env
```

---

## 3. Run the full stack

```bash
docker compose up --build
```

✅ This will:

* Start PostgreSQL
* Run Flyway migrations
* Seed database
* Start API server

---

## 🌐 API Base URL

```
http://localhost:8080
```

---

# 🔐 Authentication

### Register

```
POST /auth/register
```

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

---

### Login

```
POST /auth/login
```

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

### Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

# 🔑 Authorization

All protected endpoints require:

```
Authorization: Bearer <JWT_TOKEN>
```

---

# 📁 Projects API

### Get Projects

```
GET /projects
```

---

### Create Project

```
POST /projects
```

```json
{
  "name": "My Project",
  "description": "Optional"
}
```

---

### Get Project

```
GET /projects/{id}
```

---

### Update Project

```
PATCH /projects/{id}
```

---

### Delete Project

```
DELETE /projects/{id}
```

---

# ✅ Tasks API

### List Tasks

```
GET /projects/{id}/tasks?status=&assignee=
```

---

### Create Task

```
POST /projects/{id}/tasks
```

```json
{
  "title": "Task title",
  "description": "Optional",
  "priority": "HIGH",
  "assigneeId": "uuid",
  "dueDate": "2026-01-01"
}
```

---

### Update Task

```
PATCH /tasks/{id}
```

---

### Delete Task

```
DELETE /tasks/{id}
```

---

# ❗ Error Handling

### Validation Error (400)

```json
{
  "error": "validation failed",
  "fields": {
    "email": "must be a valid email"
  }
}
```

---

### Unauthorized (401)

```json
{
  "error": "unauthenticated"
}
```

---

### Forbidden (403)

```json
{
  "error": "forbidden"
}
```

---

### Not Found (404)

```json
{
  "error": "not found"
}
```

---

# 🗄️ Database

### Managed via Flyway

```
src/main/resources/db/migration/
```

Includes:

* Schema creation
* Indexes
* Seed data

---

# 🌱 Seed Data

Created automatically:

* 👤 User:

  ```
  email: test@example.com
  password: password123
  ```

* 📁 Project:

    * Demo Project

* ✅ Tasks:

    * TODO
    * IN_PROGRESS
    * DONE

---

# 🐳 Docker Setup

### Services

* `db` → PostgreSQL
* `api` → Spring Boot app

---

### Commands

```bash
docker compose up
docker compose down
```

---

# 🔐 Environment Variables

See `.env.example`

Key variables:

```
POSTGRES_DB
POSTGRES_USER
POSTGRES_PASSWORD
SPRING_DATASOURCE_URL
JWT_SECRET
```

---

# 🧪 Testing (Recommended Next Step)

* Integration tests using Testcontainers
* Auth flow tests
* Task CRUD tests

---

# 🚀 Future Improvements

* Pagination (`?page=&limit=`)
* Project stats endpoint
* Role-based access control
* Refresh tokens
* CI/CD pipeline
* Frontend (React)

---

# 🧠 Design Highlights

* Clean architecture (enterprise-grade)
* Stateless authentication (JWT)
* Strong validation & error handling
* Fully containerized
* Zero manual setup

---

# 📄 License

MIT (or your choice)

---

# 🙌 Contributing

PRs and improvements welcome!

---

# ⚡ Quick Start Summary

```bash
cp .env.example .env
docker compose up --build
```

Then:

👉 Login → Get token
👉 Use token → Call APIs

---

Enjoy building with TaskFlow 🚀
