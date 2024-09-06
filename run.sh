#!/bin/bash

# Call the environment check script
source ./env.sh

# If the check passes, continue with the rest of the script
echo "Running the main script..."

# Script to build, package, and run the project

# Run tests
mvn test

# Check if tests were successful
if [ $? -ne 0 ]; then
  echo "Tests failed. Please check for errors and try again."
  exit 1
fi

# Clean, compile, and package the project
mvn clean compile package

# Check if build and package were successful
if [ $? -eq 0 ]; then

  # Adding a delay before running the JAR file
  # echo "Build successful. Waiting for 5 seconds before running the JAR..."
  # sleep 5  # Delay for 5 seconds
  
  # Run the game using the packaged JAR file
  java -jar target/java-lts-features-1.0-SNAPSHOT.jar
else
  echo "Build failed. Please check for errors and try again."
fi