# Simple Gradle Project

## Overview
This project is a Java-based application using Gradle for build automation. It includes unit tests and logging configurations.

## Prerequisites
- Java 17
- Gradle 8.10
- Internet connection for downloading dependencies

## Setup
1. Clone the repository:
    ```sh
    git clone <https://github.com/Nifargo/Java-Playwright>
    cd simple-gradle-project
    ```

2. Ensure you have the required Java version:
    ```sh
    java -version
    ```

3. Verify Gradle installation:
    ```sh
    gradle -v
    ```

## Building the Project
To build the project, run:
```sh
./gradlew build
```

## Running Tests
To run the all tests, use:
```sh
./gradlew run
```

To run a specific test, use:
```sh
./gradlew test -Denv=dev
./gradlew test -Denv=preprod
./gradlew test -Denv=prod
```

## Troubleshooting
**Deprecated Gradle Features:** If you encounter warnings about deprecated Gradle features, use --warning-mode all to get detailed information.
**Logging Issues:** Ensure logback.xml is correctly configured and placed in the src/main/resources directory.
**Environment Properties:** Verify that environments.properties file exists and contains the required properties for each environment.
