# 🥷 NinjaBank - User Service

A standalone, production-ready **User and Authentication Microservice** for the NinjaBank platform.

## 📁 Project Architecture & Components

* **controller/**: `AuthController`, `HealthController`
* **service/**: `AuthService`, `OtpService`, `EmailService`
* **model/**: `User`, `PendingUser`
* **repository/**: `UserRepository`, `PendingUserRepository`
* **dto/**: Request and response DTOs for signup, login, OTP, and password reset
* **security/**: JWT authentication, Spring Security filters, and rate limiting
* **exception/**: Custom exceptions and global error handling
* **enums/**: `Role` (`USER`, `ADMIN`)

## 🚀 Running the Service

```bash
cd ninjabank-user-service
.\mvnw.cmd spring-boot:run
```
