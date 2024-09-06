# Java 8

## Overview

This module contains examples and tests for the key features introduced in Java 8, which was a significant release and marked the beginning of a new era in Java development. Java 8 introduced a number of groundbreaking features that transformed how Java developers write code.

## Key Features

1. **Lambda Expressions**: 
   - Lambda expressions enable functional programming by allowing functions to be passed as arguments and treated as first-class citizens.
   - Example: Using a lambda expression to implement an operation interface.

2. **Streams**: 
   - Streams provide a new abstraction for working with sequences of elements, making it easier to process collections of data in a declarative manner.
   - Example: Filtering a list of names starting with "J".

3. **Optional**: 
   - `Optional` is a container object used to represent a value that may or may not be present, helping to avoid `NullPointerException`.
   - Example: Using `Optional` to provide a default value if a value is absent.

4. **Date and Time API**: 
   - The new Date and Time API in `java.time` provides a more intuitive and powerful way to work with dates and times, replacing the old `java.util.Date` and `Calendar` classes.
   - Example: Formatting dates and times using `LocalDate` and `LocalDateTime`.

5. **Default Methods in Interfaces**: 
   - Default methods allow interfaces to have method implementations, enabling backward compatibility without breaking existing code.
   - Example: Implementing a default method in a `Vehicle` interface.

6. **Method References**: 
   - Method references provide a shorthand way to use existing methods as lambda expressions.
   - Example: Using a method reference to print messages from a list.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.x

### Running the Examples

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/java-lts-features.git
    cd java-lts-features/java8
    ```

2. **Build the Module**:
    Use Maven to compile the code and run the tests:
    ```bash
    mvn clean install
    ```

3. **Run the Examples**:
    Execute the JAR or individual classes to see the examples in action:
    ```bash
    java -cp target/classes com.delose.java8.LambdaExample
    ```

## Directory Structure

- `src/main/java/com/delose/java8/`: Contains the main Java classes demonstrating Java 8 features.
- `src/test/java/com/delose/java8/`: Contains unit tests for the examples.

## Contribution

Contributions are welcome! If you have additional examples or improvements, feel free to submit a pull request.

## License

This module is part of the `java-lts-features` project and is licensed under the MIT License. See the [LICENSE](../LICENSE) file for details.