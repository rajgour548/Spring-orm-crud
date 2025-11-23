🌿 Spring ORM Application (Spring Framework + Hibernate + MySQL)

A lightweight Standalone Spring ORM application demonstrating how to integrate Spring Framework, Hibernate, and MySQL in a clean and modular architecture.
This project runs as a simple Java application (not a web app) and showcases CRUD operations using DAO and Hibernate ORM, with configuration managed entirely through Spring XML.

✨ Project Highlights
```bash
🔹 Standalone Spring Core application (no web layer)

🔹 Integrated Spring ORM + Hibernate

🔹 MySQL database for persistent storage

🔹 DAO layer for clean database access

🔹 Hibernate Entity classes for ORM mapping

🔹 Centralized configuration using config.xml

🔹 Executes from main() method (App.java)

🔹 Easy to extend and perfect for learning Spring ORM concepts
```
🏗️ Tech Stack
```bash
Category	Technologies
Core Framework	Spring Core, Spring ORM
ORM	Hibernate
Database	MySQL
Build Tool	Maven
Java Version	Java 17 / 11 / 8 (whichever you used)
Project Type	Standalone Spring Application (JAR)
```
📂 Project Structure
```bash
src/
 └─ main/
     ├─ java/
     │    ├─ dao/         # DAO layer (interfaces + implementations)
     │    ├─ entity/      # Hibernate entity classes
     │    └─ App.java     # Entry point (main program)
     │
     └─ resources/
          └─ config.xml   # Spring + Hibernate merged configuration


✔ No hibernate.cfg.xml — all configuration handled via config.xml
✔ Spring manages the SessionFactory, transactions, and bean lifecycle
```
🔧 Database + ORM Configuration
```bash
Hibernate normally reads:

hibernate.cfg.xml


But in this project:

👉 All Hibernate properties (dialect, driver, URL, entities)
👉 All Spring beans (Dao, SessionFactory, DataSource)

are merged inside config.xml, and Spring loads it automatically.

This demonstrates full Spring-controlled Hibernate integration.
```
🚀 How to Run
```bash
1️⃣ Clone the repository
git clone <your-repo-url>

2️⃣ Create MySQL database

Example:

CREATE DATABASE springorm;

3️⃣ Configure DB credentials

Update inside src/main/resources/config.xml:

<property name="jdbcUrl" value="jdbc:mysql://localhost:3306/springorm"/>
<property name="username" value="root"/>
<property name="password" value="yourpassword"/>

4️⃣ Build the project
mvn clean install

5️⃣ Run the application

Execute App.java from your IDE or command line.

📘 What This Project Demonstrates

How to integrate Hibernate ORM without using hibernate.cfg.xml

How Spring manages SessionFactory and dependencies

How to structure a non-web Spring application

Clean layered approach: Entity → DAO → Main App

Real-world understanding of Spring + Hibernate setup
```
⭐ Why This Repository Is Useful
```bash
Great for beginners and intermediate learners

Ideal reference for Spring ORM interview preparation

Shows real database connectivity using Hibernate

Simple, readable codebase

Perfect starting point for larger Spring projects
```
📌 Future Enhancements (Optional)
```bash
Add service layer

Add annotation-based configuration

Replace XML with Java Config

Add Spring Boot version
```
