
# Spring Boot Basics

This repository contains code for basic CRUD operations using Spring Boot, Maven, and PostgreSQL with a Docker instance.

## Overview

This project demonstrates how to set up a Spring Boot application to perform Create, Read, Update, and Delete (CRUD) operations on a PostgreSQL database. It uses Maven for dependency management and Docker to run the PostgreSQL database instance.

## Prerequisites

Before running this project, ensure you have the following installed:

- Java Development Kit (JDK)
- Docker
- Maven

## Setup

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/your-username/spring-boot-basics.git

2. Navigate to directory
 ```bash
cd spring-boot-basics

3. start docker

 ```bash
   docker-compose up -d
4. Run docker
 ```bash
   mvn spring-boot:run

   Once the Spring Boot application is running, you can perform the following CRUD operations:

1. Create: Add a new customer to the database.
2. Read: Retrieve a list of all customers or fetch details of a specific customer by their ID.
3. Update: Update the details of an existing customer.
4. Delete: Delete a customer from the database by their ID.

You can interact with the application using RESTful endpoints. 
1. GET /api/v1/customers: Retrieve all customers.
2. GET /api/v1/customers/{id}: Retrieve details of a specific customer.
3. POST /api/v1/customers: Add a new customer.
4. PUT /api/v1/customers/{id}: Update an existing customer.
5. DELETE /api/v1/customers/{id}: Delete a customer.

   
