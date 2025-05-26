# Refactoring and Dependency Updates Explanations

This document details the changes made to update the project's Java version, Spring Boot version, and other dependencies.

## 1. Java Version Update

- **Updated to:** Java 21
- **File changed:** `pom.xml`
- **Details:** The `<java.version>` property was updated to `21`. The `maven-compiler-plugin` was already configured for source and target `21`. Java 21 is the latest Long-Term Support (LTS) version.

## 2. Spring Boot Update

- **Updated to:** Spring Boot `3.5.0-M1` (Milestone version)
- **File changed:** `pom.xml`
- **Details:** The parent POM version for `spring-boot-starter-parent` was updated to `3.5.0-M1`.
- **Note on Pre-release:** `3.5.0-M1` is a milestone release. This means it's not yet General Availability (GA) and might contain features that are subject to change or bugs. Production use of milestone versions is generally discouraged. The project's `pom.xml` already included Spring milestone repositories, which are necessary for resolving this version.

## 3. Spring Cloud Update

- **Updated to:** Spring Cloud `2025.0.0-M1` (Milestone version)
- **File changed:** `pom.xml`
- **Details:** The `<spring-cloud.version>` property was updated to `2025.0.0-M1`. This version aligns with Spring Boot `3.5.0-M1` according to Spring Cloud release train compatibility.
- **Note on Pre-release:** Similar to Spring Boot, this is a milestone version and may not be stable for production use. Spring milestone repositories are required.

## 4. Other Dependency Updates

- **File changed:** `pom.xml`
- **Details:**
    - **Testcontainers:** `<testcontainers.version>` updated from `1.19.3` to `1.19.8`.
    - **JavaMoney (Moneta):** `<java-money.version>` updated from `1.4.3` to `1.4.4`.
    - **SpringDoc OpenAPI UI:** `<springdoc-openapi.version>` updated from `2.3.0` to `2.5.0`.
    - **MapStruct:** `<mapstruct.version>` kept at `1.5.5.Final`. This version is stable and will be monitored for compatibility.
    - Other dependencies like Apache Commons Lang, Jacoco, Pitest, OWASP are largely managed by the Spring Boot parent POM. Their versions will be determined by `spring-boot-starter-parent:3.5.0-M1`.

## 5. Test Database Update (PostgreSQL via Testcontainers)

- **Updated to:** PostgreSQL version 16
- **File changed:** `src/test/resources/application-test.properties`
- **Details:** The JDBC URL for Testcontainers was changed from `jdbc:tc:postgresql:15.2:///...` to `jdbc:tc:postgresql:16:///...`. This ensures tests run against a more recent version of PostgreSQL.

## 6. Schema Management

- **Observation:** No explicit schema management tool (like Flyway or Liquibase) is configured for the main application. The `spring.jpa.hibernate.ddl-auto` property is not set in `src/main/resources/application.properties`, and no `schema.sql` exists in `src/main/resources`.
- **Assumption:** It's assumed that the database schema for the main application is managed externally/manually. The updates performed in this refactoring rely on the existing schema being compatible with the updated libraries (especially Hibernate 6.x, which is part of Spring Boot 3.x).
- **Test Environment:** The test environment uses `TC_INITSCRIPT=schema.sql` with Testcontainers, ensuring a consistent schema for tests based on `src/test/resources/schema.sql`.

## 7. General Considerations for Pre-release Versions

- Using milestone versions (like Spring Boot `3.5.0-M1` and Spring Cloud `2025.0.0-M1`) can introduce instability or breaking changes before they reach GA. It's crucial to perform thorough testing.
- APIs might change between milestone releases and the final GA version.
- It's recommended to update to GA versions as soon as they become available and are deemed stable for the project's needs.
