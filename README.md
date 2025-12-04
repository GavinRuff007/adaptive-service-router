# service-integration-platform

---

# 🌐 **Adaptive Service Router**

### *A Clean Architecture–Driven, Pluggable Integration Layer for Multi-Provider Systems*

<p align="center">
  <img src="https://img.shields.io/badge/Architecture-Clean%20%26%20Hexagonal-4CAF50?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-21-007396?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.4+-6DB33F?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Domain-Driven%20Design-DDD-blue?style=for-the-badge"/>
</p>

---

## 🚀 **Overview**

**Adaptive Service Router** is a modular, high-performance integration layer built using
**Clean Architecture**, **Hexagonal Design**, and **provider-based routing**.

It enables any application to dynamically select external service providers at runtime —
without modifying business logic.

You simply define **domain rules**, **use cases**, and **provider adapters**,
and this framework handles the routing, orchestration, and abstraction.

---

## ✨ **Key Features**

### 🔹 Clean Architecture from the ground up

Strict separation: **Domain → Application → Infrastructure**

### 🔹 Provider Routing

Choose an active provider via config:

```yaml
provider:
  active: gsb
```

Supports unlimited providers:

* `sandbox`
* `gsb`
* `astan`
* future custom providers…

### 🔹 Domain-Driven Value Objects

* `NationalId` (with algorithm validation)
* `BirthDate`
* Domain rules live in domain — not in controllers or services.

### 🔹 Framework-Independent Core

Domain & Application have **zero Spring annotations** → highly testable & reusable.

### 🔹 Infrastructure with Spring Boot

REST API, provider wiring, configs, outgoing adapters.

### 🔹 Extensible for enterprise integrations

Ideal for government, banking, fintech, telecom, and any system needing multi-provider routing.

---

## 🧩 **Architecture**

```
.
├── rip-government-domain
│   ├── entity
│   ├── valueobject
│   ├── exception
│   └── Domain rules only
│
├── rip-government-application
│   ├── port
│   │   ├── input  (Use Cases)
│   │   └── output (Provider interfaces)
│   └── service (Business logic)
│
├── rip-government-infrastructure
│   ├── api (Controllers)
│   ├── adapter (External provider adapters)
│   ├── config (Routing & Spring beans)
│   └── GovernmentServiceApplication.java
└── pom.xml (root)
```

### 🧠 *High-level flow*

```
Controller → UseCase → ProviderPort → ProviderAdapter → External System
```

---

## 🛠 **Tech Stack**

* **Java 21**
* **Spring Boot 3.4+**
* **Spring Web MVC**
* **Clean Architecture principles**
* **DDD Value Objects**
* **MapStruct (optional mapping)**
* **OpenAPI / Swagger UI**
* **Resilience4j (optional future use)**

---

## ⚙️ **Configuration**

The router chooses the provider based on:

`application.yml`:

```yaml
provider:
  active: sandbox  # or gsb / astan / your-custom-provider
```

Add your provider configs like:

```yaml
providers:
  gsb:
    url: https://example.com/api
```

---

## 🚦 **Running the Project**

### 1️⃣ Install all modules

```bash
mvn clean install
```

### 2️⃣ Run the service

Using IntelliJ or:

```bash
cd rip-government-infrastructure
mvn spring-boot:run
```

### 3️⃣ Access Swagger UI

```
http://localhost:8080/swagger-ui.html
```

---

## 📡 **Example API Request**

### **POST** `/api/v1/identity/inquiry`

#### Request body:

```json
{
  "nationalId": "0025235141",
  "birthDate": "13810903"
}
```

#### Sample response:

```json
{
  "match": true,
  "firstName": "Ali",
  "lastName": "Ahmadi",
  "fatherName": "Reza",
  "birthDate": "13810903"
}
```

---

## 🧪 **Testing Strategy**

* **Domain tests** → validate NationalId algorithm, BirthDate rules
* **UseCase tests** → mock output ports
* **Adapter tests** → HTTP mocking (WireMock recommended)
* **Integration tests** → Spring Boot + Testcontainers (future enhancement)

---

## 📡 **Provider Routing Logic**

The router receives all provider beans:

```java
Map<String, CivilRegistryProviderPort> providers
```

Then selects:

```java
providers.get(activeProvider)
```

This makes adding new providers as simple as:

1. Creating a new Adapter class
2. Marking it with `@Service("providerName")`
3. Updating config:

```yaml
provider.active: providerName
```

Done — no core change.

---

## 🛠️ Future Enhancements

* 🔄 Provider fallback + chain of responsibility
* 🧵 Async & non-blocking providers
* 🔌 gRPC providers
* 📊 OpenTelemetry tracing
* 🛡 Circuit breaker per provider
* 🧩 Multi-provider aggregation strategy
* 🔐 API security module

---

## 🤝 **Contributions**

PRs, forks, suggestions, and feature requests are warmly welcomed.

---

## ⭐ If you like this architecture, consider giving the repository a star!

---

اگر بخواهی می‌توانم:

✅ README را **به فارسی** هم بنویسم
✅ **diagram Mermaid** مثل پروژه‌های Netflix اضافه کنم
✅ Badgeهای حرفه‌ای GitHub (test coverage, build status، release version) اضافه کنم
✅ یک **logo حرفه‌ای** برای پروژه طراحی کنم
فقط بگو!
