# Java LTS Features

## Overview

The `java-lts-features` repository is a comprehensive resource designed to showcase and explore key features introduced in each Long-Term Support (LTS) version of Java. Each version is represented as a separate module within this repository, allowing developers to understand the evolution of Java through practical examples and tests.

## Structure

The repository is organized by Java versions, with each version having its own module. The main modules include:

- **Java 8**: Features introduced in Java 8.
- **Java 11**: Features introduced in Java 11.
- **Java 17**: Features introduced in Java 17.
- **Java 25**: Features introduced in Java 25 (latest LTS).
- (Add more modules as needed)

## How to Use

Each module contains:
- **Source Code**: Examples of the new features introduced in the respective Java version.
- **Unit Tests**: Tests that demonstrate the usage of these features.
- **Documentation**: A README file in each module that provides an overview of the features and how to run the examples.

### Modules

1. **java8**: Contains examples and tests for Java 8 features, including lambda expressions, streams, optional, the new Date and Time API, default methods in interfaces, and method references.
2. **java11**: Contains examples and tests for Java 11 features, including new String methods, file handling improvements, and local variable syntax for lambda parameters.
3. **dsa**: Data Structures and Algorithms implementations in Java.
4. **practice**: Practice problems and wrapper classes for collections and other utilities.
5. **java17**: Contains examples and tests for Java 17 features, including sealed classes, records, pattern matching for instanceof, and text blocks.
6. **design-patterns**: Creational design patterns implementation (Builder, Factory Method).
7. **toolkit**: Utility classes for common operations (character counting, etc.).
8. **java21**: Contains examples and tests for Java 21 features.
9. **java25**: Contains examples and tests for Java 25 features (see below).

## Java 25 Features (LTS)

The `java25` module showcases the following Java 25 features:

### 1. Compact Object Headers (JEP 519)
- Reduces object header size from 12-16 bytes to 8 bytes
- Can reduce heap usage by up to 20%
- **Enable with JVM args**: `-XX:+UnlockExperimentalVMOptions -XX:+UseCompactObjectHeaders`
- See `java25/README.md` for performance testing details.

### 2. Flexible Constructor Bodies (JEP 513) [STANDARD]
- Allows statements before `super()` or `this()` calls
- Enables validation and calculations before constructor chaining
- Example: `com.delose.java.lts.java25.constructor.FlexibleConstructorDemo`

### 3. Scoped Values (JEP 506) [PREVIEW]
- Replacement for `ThreadLocal` with better performance and safety
- Immutable once bound, automatic cleanup
- Works better with virtual threads
- **Requires**: `--enable-preview` JVM flag
- Example: `com.delose.java.lts.java25.scoped.ScopedValuesDemo`

### 4. Module Import Declarations (JEP 511) [STANDARD]
- Import all types from a module: `import module java.base;`
- Reduces boilerplate imports
- Example: `com.delose.java.lts.java25.imports.ModuleImportDemo`

### 5. Stable Values API (JEP 502) [PREVIEW]
- Lazy initialization with JVM constant treatment
- Safe publication without synchronization
- **Requires**: `--enable-preview` JVM flag
- Example: `com.delose.java.lts.java25.stable.StableValuesDemo`

### 6. Pattern Matching for Primitives (JEP 507) [PREVIEW]
- `instanceof` and `switch` can match primitive types directly
- Automatic unboxing from wrapper types
- **Requires**: `--enable-preview` JVM flag
- Example: `com.delose.java.lts.java25.pattern.PrimitivePatternMatchingDemo`

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

### Running Java 25 Examples

**Standard features (no preview required)**:
