# AutomationFramework

A Java-based test automation framework for web, API, and data validation testing.  
Built with Selenium 4, Cucumber 7, TestNG 7, Gradle 8, REST Assured, Hibernate, and GitHub Actions.

## Overview

This project demonstrates a structured QA automation framework designed to support regression testing, API validation, BDD test coverage, and CI/CD execution.

The framework is intended to show practical SDET skills, including:

- Web UI automation using Selenium
- BDD-style test scenarios using Cucumber
- Test execution and organization using TestNG
- API testing using REST Assured
- Database/data-layer support using Hibernate
- Build and dependency management using Gradle
- CI execution through GitHub Actions

## Tech Stack

| Area | Tools |
|---|---|
| Programming Language | Java |
| Web Automation | Selenium 4 |
| BDD | Cucumber 7 |
| Test Runner | TestNG 7 |
| API Testing | REST Assured |
| Build Tool | Gradle 8 |
| Data Access | Hibernate |
| CI/CD | GitHub Actions |

## Project Structure

```text
AutomationFramework/
├── .github/workflows/     # GitHub Actions workflow files
├── gradle/wrapper/        # Gradle wrapper files
├── src/                   # Test source code and framework logic
├── build.gradle           # Gradle build configuration
├── settings.gradle        # Gradle project settings
├── gradlew                # Gradle wrapper for Linux/Mac
└── gradlew.bat            # Gradle wrapper for Windows
```

## Key Features

- Page Object Model style structure for maintainable UI automation
- BDD scenarios for readable test coverage
- API validation using REST Assured
- Test execution through TestNG
- Gradle-based project setup
- GitHub Actions configuration for CI execution
- Framework structure suitable for regression and smoke testing

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java JDK 8 or higher
- Git
- Gradle, or use the included Gradle wrapper
- A supported browser for Selenium execution

### Clone the repository

```bash
git clone https://github.com/mohmeida/AutomationFramework.git
cd AutomationFramework
```

### Run tests

Using the Gradle wrapper:

```bash
./gradlew test
```

On Windows:

```bash
gradlew.bat test
```

## CI/CD

This framework includes GitHub Actions configuration under:

```text
.github/workflows/
```

The CI setup can be used to trigger automated test execution as part of the development workflow.

## Why This Project Matters

This repository highlights practical QA automation and SDET experience, including framework design, UI automation, API testing, BDD coverage, and CI/CD integration.

It reflects hands-on experience building automation frameworks that support faster regression cycles, better test visibility, and improved release confidence.

## Author

**Mohammed Hmeidan**  
Senior SDET / QA Automation Engineer

- LinkedIn: https://www.linkedin.com/in/mohammed-h-25qa/
- GitHub: https://github.com/mohmeida/AutomationFramework
