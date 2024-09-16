<div align="center">

# Order Management System

[![Study](https://skillicons.dev/icons?i=java,spring,postgresql)](https://skillicons.dev) 

</div>

![Badge em Desenvolvimento](https://img.shields.io/badge/project%20status:-in%20development-purple)

</h4>

<br>

> [!NOTE]
> I'll adjust the readme as I develop the application(this includes adding a topic to show how you can download and view it in your PC), because I believe it is important to document everything in a much clearer and comprehensive way, but for now it provides a good overview of the project's core.

<br>

✨ Give this repository a star!

<br>

Order Management System is a backend solution built to manage orders in a store. It enables the creation, retrieval, updating, and deletion of customers, vendors, and orders. All data is stored and managed using a PostgreSQL database. This system is designed to automate key processes such as tracking customer credit limits, vendor commissions, and linking orders to the correct customer and vendor.

## 💭 Initial Thinking

This project represents my first experience working with Spring Boot and JPA. Previously, I used JDBC and plain Java for my applications, but I wanted to explore more modern tools and approaches, so I chose to follow the Controller-Service-Repository design pattern, alongside Entities and DTOs to ensure better separation of concerns and maintainable code.

## 🎠 Features

### 1. Customer Management
- Register and maintain customer information.
- Track customer credit limits and available credit.
- Manage customer orders and link them to specific vendors.

### 2. Vendor Management
- Register and maintain vendor details.
- Manage vendor commissions based on orders processed.
- Link vendors to specific sales orders for commission tracking.

### 3. Order Processing
- Create, modify, and delete sales orders.
- Link orders to specific customers and vendors.
- Automatically update customer credit limits based on the orders.
- Retrieve customer and vendor information using their unique identifiers.

### 4. Data Persistence
- All data is stored in a **PostgreSQL** database.
- Use **Spring Data JPA** for seamless interaction with the database.

## 💻 Technologies Used

- **JDK 21 (Amazon Corretto)**: Java is the primary language for this project.
- **Spring Boot**: Simplifies the development of the application.
  - **Spring Data JPA**: For managing data persistence and database interactions.
- **PostgreSQL**: The relational database used for data storage.
- **Maven**: Dependency management and project building.

## 📖 Project Structure

The project follows the **Controller-Service-Repository** architecture pattern, with additional layers for **Entities** and **DTOs** to enhance modularity and maintainability.

## 📸 Project's Screenshots

<details>
<summary align="left">Project's screenshot</summary>
<br>

  ![screenshot](images/projects-screenshot.png)

</details>

<div align="center">
 <img align="center" src="https://em-content.zobj.net/source/microsoft/309/ninja-cat_1f431-200d-1f464.png" alt="Ninja Cat" width="30" height="auto">
</div>