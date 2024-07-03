# CloudAuthentication

![License](https://img.shields.io/github/license/NoSoyRo/CloudAuthentication)
![Issues](https://img.shields.io/github/issues/NoSoyRo/CloudAuthentication)
![Stars](https://img.shields.io/github/stars/NoSoyRo/CloudAuthentication)

## Description

CloudAuthentication is a project aimed at providing a cloud-based authentication solution. It uses Spring Boot and Thymeleaf for implementing interfaces and services related to orders and products.

## Features

- Secure user authentication
- Management of orders and products
- Intuitive user interface with Thymeleaf
- Architecture based on Spring Boot

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Installation

1. Clone the repository:
    ```sh
    git clone git@github.com:NoSoyRo/CloudAuthentication.git
    cd CloudAuthentication
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Usage

1. Run the application:
    ```sh
    mvn spring-boot:run
    ```

2. Open your web browser and go to `http://localhost:8080` to access the application.

## Project Structure

```plaintext
CloudAuthentication/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       └── java/
├── .gitignore
├── pom.xml
└── README.md
