# Restful Booker – API Test Framework

A lightweight API test automation framework built to demonstrate clean structure, maintainable design, and CI/CD integration.

Target API: https://restful-booker.herokuapp.com/

---

## Overview

This framework tests the Restful Booker API (authentication, health check, bookings) using a clean and scalable structure.

Focus areas:
- separation of concerns (config, clients, models, tests)
- TestNG-based execution (smoke + regression)
- reusable API clients
- environment-based configuration
- Allure reporting support
- CI/CD ready with GitHub Actions

---

## Project Structure
```
src/test/java/com/restfulbooker/
├── config/          # environment config
├── constants/       # endpoints and constants
├── models/          # request/response POJOs
├── clients/         # API clients (Auth, Booking, BaseClient)
├── utils/           # helpers and utilities
├── base/            # base test setup
├── tests/           # test classes
├── dataproviders/   # test data providers
└── suites/          # TestNG suites (smoke, regression)
```
## Tech Stack

- Java 21
- RestAssured
- TestNG
- Allure Reports
- AssertJ
- Lombok
- Maven Wrapper
- GitHub Actions

---
## How to Run

### Prerequisites
- Java 21+
- Git
- Maven

### Run tests
Report here: https://adriansebastiann.github.io/restful-booker-tests/reports/
```bash
mvn clean test -Dsuite=smoke -Denv=local
