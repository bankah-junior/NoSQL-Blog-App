# Smart Blogging Platform – Database Fundamentals Project

## Overview
The Smart Blogging Platform is a data-driven blogging system designed to demonstrate strong understanding of **database design, normalization, performance optimization, and JavaFX–database integration**.

The project focuses on building a robust **data layer and persistence logic** that supports core blogging operations such as post creation, comment management, tagging, searching, sorting, and performance analytics.

This project emphasizes **engineering correctness, scalability, and performance**, rather than UI complexity.

---

## Project Objectives
By completing this project, the system demonstrates the ability to:

- Design conceptual, logical, and physical database models
- Normalize relational schemas to **Third Normal Form (3NF)**
- Implement CRUD operations using **JavaFX and JDBC**
- Apply **indexing, caching, searching, and sorting algorithms**
- Compare **SQL and NoSQL** approaches for unstructured data
- Measure and document performance improvements
- Maintain clean, layered architecture and documentation

---

## Technology Stack

### Backend & Application
- **Java 17+**
- **JavaFX**
- **JDBC**
- **Maven** (build & dependency management)

### Databases
- **MySQL / PostgreSQL** (Relational – primary)
- **MongoDB** (Optional – NoSQL for unstructured data)

### Tools
- ERD Tool (Draw.io / MySQL Workbench)
- Git & GitHub
- IDE (IntelliJ IDEA / Eclipse)

---

## Project Structure

```

BloggingPlatform/
│
├── src/
│   ├── main/
│   │   ├── java/com/blogplatform/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── dao/
│   │   │   ├── model/
│   │   │   ├── util/
│   │   │   └── MainApp.java
│   │   │
│   │   └── resources/
│   │       ├── fxml/
│   │       ├── css/
│   │       └── images/
│   │
│   └── test/
│       └── java/com/blogplatform/
│
├── scripts/
│   ├── sql/
│   └── nosql/
│
├── docs/
│   ├── ERD/
│   ├── PerformanceReport.md
│   └── THOUGHTPROCESS.md
│
├── pom.xml
├── README.md
└── .gitignore

```

---

## Database Design

### Core Entities
- Users
- Posts
- Comments
- Tags
- Reviews

### Key Features
- Schema normalized to **3NF**
- Primary and foreign keys enforce referential integrity
- Indexes applied to frequently queried columns:
  - Post title
  - Author ID
  - Tag name

### NoSQL (Optional)
- MongoDB used for storing unstructured comments or reviews
- Demonstrates schema flexibility and scalability trade-offs

---

## Application Architecture

The system follows a **layered architecture**:

```

Controller → Service → DAO → Database

```

### Layer Responsibilities
- **Controller**: Handles JavaFX UI events
- **Service**: Business logic, caching, sorting, validation
- **DAO**: Database interaction via JDBC or MongoDB driver
- **Util**: DB connection, caching, performance logging

This approach improves maintainability and testability.

---

## Features

### Core Functionalities
- Create, update, delete blog posts
- Manage comments and tags
- Search posts by keyword, author, or tag
- Sort posts by date or title
- Pagination and filtering
- Input validation and feedback

### Performance Optimizations
- Database indexing
- In-memory caching using Maps and Lists
- Optimized searching and sorting algorithms
- Measured pre- and post-optimization improvements

---

## Data Structures & Algorithms Usage

| Concept | Implementation |
|------|---------------|
| Hashing | In-memory cache using `HashMap` |
| Searching | Indexed DB search + cached search |
| Sorting | QuickSort / Java optimized sorting |
| Indexing | DB indexes mapped to DSA concepts |
| Caching | Frequently accessed posts |

---

## Performance Measurement

Performance is measured by:
- Query execution time before indexing
- Query execution time after indexing
- Cache vs non-cache retrieval comparisons

Results are documented in:
```

docs/PerformanceReport.md

````

---

## Setup Instructions

### 1. Clone Repository
```bash
git clone <repository-url>
cd BloggingPlatform
````

### 2. Database Setup (SQL)

1. Create a database
2. Run SQL scripts in order:

```sql
scripts/sql/create_tables.sql
scripts/sql/insert_sample_data.sql
scripts/sql/create_indexes.sql
```

### 3. Configure Database Connection

Update database credentials in:

```
util/DBConnection.java
```

### 4. Build Project

```bash
mvn clean install
```

### 5. Run Application

```bash
mvn javafx:run
```

---

## Testing

* DAO and Service layer tests are included
* Screenshots or console logs demonstrate correct behavior
* Validation and constraint enforcement verified

---

## Documentation

* **ERD Diagrams**: `docs/ERD/`
* **Design Rationale**: `docs/THOUGHTPROCESS.md`
* **Performance Analysis**: `docs/PerformanceReport.md`
* **SQL / NoSQL Scripts**: `scripts/`

---

## Evaluation Alignment

| Criteria                 | Covered                       |
| ------------------------ | ----------------------------- |
| Database Design          | ✔ ERD, 3NF, constraints       |
| SQL / NoSQL              | ✔ Indexed schema, scripts     |
| JavaFX + JDBC            | ✔ CRUD + layered design       |
| DSA Application          | ✔ Caching, searching, sorting |
| Performance Optimization | ✔ Measured improvements       |
| Documentation            | ✔ Complete and structured     |

---

## Conclusion

This project demonstrates a real-world approach to building a scalable, optimized, and maintainable data-driven system. It integrates database theory, data structures, and Java application development into a cohesive and extensible blogging platform.

---

## Author

**Anthony Bekoe Bankah**
Smart Blogging Platform – Database Fundamentals
