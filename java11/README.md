# Java 11 Features

## Overview

This module demonstrates key features introduced in Java 11, including enhancements to the language syntax, new APIs, and useful methods added to existing classes.

## Key Features

1. **Local-Variable Syntax for Lambda Parameters**:
   - Java 11 allows the use of `var` in lambda expressions, making code more concise and readable.
   - **Example**: Implementing a BiFunction using `var` in the lambda parameters.

2. **HTTP Client API**:
   - Java 11 introduced a new, modern HTTP Client API that supports synchronous and asynchronous operations.
   - **Example**: Fetching data from a REST API using the new HTTP Client.

3. **New String Methods**:
   - Several useful methods have been added to the `String` class, including `isBlank`, `lines`, `strip`, and `repeat`.
   - **Example**: Demonstrating how to use these new string manipulation methods.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.x

### Running the Examples

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/java-lts-features.git
    cd java-lts-features/java11
    ```

2. **Build the Module**:
    Use Maven to compile the code and run the tests:
    ```bash
    mvn clean install
    ```

3. **Run the Examples**:
    Execute the JAR or individual classes to see the examples in action:
    ```bash
    java -cp target/classes com.delose.java11.HttpClientExample
    ```

## Directory Structure

- `src/main/java/com/delose/lts/java11/`: Contains the main Java classes demonstrating Java 11 features.
- `src/test/java/com/delose/lts/java11/`: Contains unit tests for the examples.

## Contribution

Contributions are welcome! If you have additional examples or improvements, feel free to submit a pull request.

## License

This module is part of the `java-lts-features` project and is licensed under the MIT License. See the [LICENSE](../LICENSE) file for details.