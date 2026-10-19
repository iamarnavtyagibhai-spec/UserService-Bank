# 🥷 NinjaBank - User & Authentication Microservice

Production-ready, cloud-native **User Authentication & Identity Microservice** for the **NinjaBank Platform** built with **Spring Boot 3.5**, **Spring Security 6 (Stateless JWT)**, **PostgreSQL (Neon)**, and **Brevo Transactional Email Engine**.

---

## 🌟 Core Features

- **🔐 Stateless JWT Authentication**:
  - HMAC-SHA256 encrypted access tokens with customizable expiry.
  - Role-based authorization (`USER`, `ADMIN`, `KAGE`).
- **📬 2-Step Registration Flow**:
  - Dispatches 6-digit email OTP via Brevo API.
  - `PendingUser` staging table to prevent unverified account sprawl.
- **🛡️ Resilience & Security**:
  - Global Exception Handling with structured JSON responses.
  - BCrypt password hashing.
  - Built-in CORS filter for multi-origin microservice architectures.
- **⚡ Health Monitoring**:
  - Dedicated `/auth/health` endpoint for Docker and Render health checks.

---

## 📖 API Endpoints

| Method | Endpoint | Access | Description |
| :--- | :--- | :---: | :--- |
| `GET` | `/auth/health` | Public | Service health verification |
| `POST` | `/auth/signup` | Public | Initial registration & dispatch 6-digit OTP |
| `POST` | `/auth/verify-otp` | Public | Verify OTP & activate user account |
| `POST` | `/auth/resend-otp` | Public | Resend verification OTP |
| `POST` | `/auth/login` | Public | Authenticate credentials & return JWT |
| `POST` | `/auth/forgot-password` | Public | Trigger password recovery OTP |
| `POST` | `/auth/verify-forgot-otp` | Public | Validate password recovery OTP |
| `POST` | `/auth/reset-password` | Public | Set new BCrypt password |

---

## ⚙️ Environment Configuration

| Variable | Default Value | Description |
| :--- | :--- | :--- |
| `SERVER_PORT` | `8081` | Web server listening port |
| `SPRING_DATASOURCE_URL` | `jdbc:postgresql://localhost:5432/ninjabank_user` | PostgreSQL connection URL |
| `SPRING_DATASOURCE_USERNAME` | `postgres` | Database username |
| `SPRING_DATASOURCE_PASSWORD` | `postgres` | Database password |
| `JWT_SECRET` | *(256-bit secret)* | Secret key for JWT signing & verification |
| `JWT_EXPIRATION` | `86400000` | Token validity in milliseconds (24 Hours) |
| `BREVO_API_KEY` | *(empty)* | Brevo (Sendinblue) transactional email API key |
| `BREVO_SENDER_EMAIL` | `noreply@ninjabank.com` | Verified sender address |
| `BREVO_SENDER_NAME` | `NinjaBank` | Sender display name |

---

## 🚀 Running Locally

```bash
# Set environment variables (or create .env file)
.\mvnw.cmd clean spring-boot:run
```

---

## 🐳 Docker Deployment

```bash
# Build Docker image
docker build -t ninjabank-user-service .

# Run container
docker run -d -p 8081:8081 --name ninjabank-user-service ninjabank-user-service
```
