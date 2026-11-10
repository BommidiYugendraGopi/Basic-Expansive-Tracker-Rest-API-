# *****💰 Expense Tracker API 💰*****

A RESTful Expense Tracker API built with **Java**, **Spring Boot**, and **Spring Data JPA**. It provides endpoints to create, retrieve, update, and delete expense records.

## ✨ Features

- ➕ Create a new expense
- 📋 Retrieve all expenses
- 🔍 Retrieve an expense by its ID
- ✏️ Update an existing expense
- 🗑️ Delete an expense by its ID
- 💾 Persist expense data using JPA

## 🛠️ Tech Stack

- ☕ Java
- 🌱 Spring Boot
- 🌐 Spring Web
- 🗄️ Spring Data JPA
- 🔗 Jakarta Persistence (JPA)
- 🛢️ Relational Database
- 📦 Maven or Gradle

## 📁 Project Structure

```text
com.Vcube.ExpanceTrackerAPI
├── module
│   ├── Controller
│   │   └── ExpanceController.java
│   └── Expance.java
└── Repo
    └── ExpanceRepo.java
```

`ExpanceRepo` is the Spring Data repository used by the controller. Its implementation and database configuration are not included in the supplied code.

## 🧾 Expense Data Model

The `Expance` entity maps to the database table `expenses78`.

| Field | Java Type | Description |
|---|---|---|
| 🆔 `id` | `Integer` | Primary key, generated using IDENTITY |
| 📝 `title` | `String` | Expense title |
| 📄 `description` | `String` | Expense details |
| 💵 `amount` | `BigDecimal` | Expense amount |
| 🏷️ `category` | `String` | Expense category |
| 💳 `paymentMode` | `String` | Payment method |
| 📅 `expenseDate` | `LocalDate` | Date of the expense |
| 🏪 `merchantName` | `String` | Merchant or shop name |
| 📍 `city` | `String` | City where the expense occurred |
| 🕒 `createdAt` | `LocalDateTime` | Record creation date and time |

The entity has a no-argument constructor and public getters and setters.

## 🌐 API Base URL

The controller has the class-level mapping:

```http
/Expances
```

The spelling `/Expances` is retained to match the supplied source code.

## 🔗 API Endpoints

| HTTP Method | Endpoint | Purpose |
|---|---|---|
| 📥 GET | `/Expances/FindAll` | Get all expenses |
| ➕ POST | `/Expances/create` | Create an expense |
| 🔍 GET | `/Expances/getExpance/{id}` | Get an expense by ID |
| ✏️ PUT | `/Expances/update/{id}` | Update an expense |
| 🗑️ DELETE | `/Expances/deleteExpance/{id}` | Delete an expense |

### 1️⃣ 📋 Get All Expenses

```http
GET /Expances/FindAll
```

Returns the list of expenses using `er.findAll()`.

### 2️⃣ ➕ Create an Expense

```http
POST /Expances/create
Content-Type: application/json
```

**Example Request Body:**

```json
{
  "title": "Groceries",
  "description": "Monthly grocery shopping",
  "amount": 2450.50,
  "category": "Food",
  "paymentMode": "UPI",
  "expenseDate": "2026-11-10",
  "merchantName": "Local Supermarket",
  "city": "Bhubaneswar",
  "createdAt": "2026-11-10T18:30:00"
}
```

The controller passes the request entity to `er.save(e)` and returns the saved entity.

### 3️⃣ 🔍 Get Expense By ID

```http
GET /Expances/getExpance/1
```

Replace `1` with the required expense ID.

The current implementation calls:

```java
er.findById(id).get();
```

### 4️⃣ ✏️ Update an Expense

```http
PUT /Expances/update/1
Content-Type: application/json
```

**Example Request Body:**

```json
{
  "title": "Updated groceries",
  "description": "Updated shopping details",
  "amount": 2600.00,
  "category": "Food",
  "paymentMode": "Card",
  "expenseDate": "2026-11-10",
  "merchantName": "Local Supermarket",
  "city": "Bhubaneswar",
  "createdAt": "2026-11-10T19:00:00"
}
```

The controller retrieves the existing record and copies the request fields into it.

⚠️ **Important:** The supplied code uses:

```java
return er.save(e);
```

It should be:

```java
return er.save(Efdb);
```

This saves the modified entity fetched from the database.

### 5️⃣ 🗑️ Delete an Expense

```http
DELETE /Expances/deleteExpance/1
```

Deletes the record with the supplied ID.

The current controller returns the text `"deleted id"`.

## 🚀 Running the Project

Follow these steps to run the API:

1. 💻 Open the Spring Boot project in your IDE.
2. 📦 Ensure the project includes Spring Web and Spring Data JPA dependencies.
3. 🗄️ Ensure `ExpanceRepo` extends an appropriate Spring Data repository, such as `JpaRepository<Expance, Integer>`.
4. ⚙️ Configure the database connection and JPA settings in `application.properties` or `application.yml`.
5. ▶️ Run the Spring Boot application class.
6. 🧪 Test the endpoints using Postman or another HTTP client.

## 🔧 Important Improvements to Consider

The following are recommendations and are not implemented in the supplied controller:

- 🛡️ Replace `.findById(id).get()` with `orElseThrow(...)` and return HTTP `404 Not Found` when an expense does not exist.
- 📡 Use `ResponseEntity` to return appropriate HTTP status codes.
- ✅ Add validation for required fields and ensure the amount is positive.
- 🕒 Set `createdAt` when creating a record rather than accepting arbitrary client values.
- 🏗️ Consider adding a service layer between the controller and repository.
- 📦 Use DTOs to separate API request/response data from the JPA entity.
- ✨ Follow conventional Java naming: `Expense`, `ExpenseController`, and `ExpenseRepo` rather than `Expance` if you are willing to rename the existing classes and routes.

## 📌 Current Scope

This README documents the controller and entity code provided.

The following features are not specified in the supplied code:

- 🔐 Authentication and authorization
- 📄 Pagination
- 🔎 Filtering and searching
- 📊 Expense reports and analytics
- ☁️ Deployment configuration
- 🛢️ Database vendor

---

## 👨‍💻 Author

**Expense Tracker API**

Built with ❤️ using Java and Spring Boot.
