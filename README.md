# Shortify - URL Shortener

Shortify is a simple URL shortener service built with Spring Boot and H2 database. It allows users to shorten long URLs and access them through shorter, easier-to-remember links.

## Features

- Shorten long URLs
- Redirect to the original URL via the shortened URL
- Simple REST API for creating and accessing shortened URLs

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.4**
- **H2 Database** (in-memory for development)
- **Spring Data JPA**
- **Hibernate**
- **Redis**

## Getting Started

Follow these steps to set up and run the project locally:
1. git clone https://github.com/tangmmy/Shortify.git
2. mvn clean install
3. mvn springboot:run

### Prerequisites

Ensure you have the following installed:
- **Java 17** or higher
- **Maven**
- **Redis**
