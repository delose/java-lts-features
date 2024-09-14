# Java LTS Features

## Overview

The `java-lts-features` repository is a comprehensive resource designed to showcase and explore key features introduced in each Long-Term Support (LTS) version of Java. Each version is represented as a separate module within this repository, allowing developers to understand the evolution of Java through practical examples and tests.

## Structure

The repository is organized by Java versions, with each version having its own module. The main modules include:

- **Java 8**: Features introduced in Java 8.
- **Java 11**: Features introduced in Java 11.
- **Java 17**: Features introduced in Java 17.
- (Add more modules as needed)

## How to Use

Each module contains:
- **Source Code**: Examples of the new features introduced in the respective Java version.
- **Unit Tests**: Tests that demonstrate the usage of these features.
- **Documentation**: A README file in each module that provides an overview of the features and how to run the examples.

### Modules

1. **java8**: Contains examples and tests for Java 8 features, including lambda expressions, streams, optional, the new Date and Time API, default methods in interfaces, and method references.
2. **java11**: (Placeholder for future content)
3. **java17**: (Placeholder for future content)
4. **dsa**: (Placeholder for future content)

## Getting Started

To start using this repository:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/java-lts-features.git
    cd java-lts-features
    ```

2. **Navigate to a Module**:
    ```bash
    cd java8
    ```

3. **Build and Test**:
    Use Maven to build and test the module:
    ```bash
    mvn clean install
    ```

4. **Explore the Examples**:
    Review the examples and tests provided in each module to learn more about the features introduced in that version.

## Developer Notes

1. **Initialize project with Maven:**

    ```sh
    mvn archetype:generate -DgroupId=com.delose.java.lts -DartifactId=java-lts-features -DpackageName=com.delose.java11 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
    ```

## Contribution

Contributions are welcome! If you'd like to add examples for other LTS versions or improve the existing ones, feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.