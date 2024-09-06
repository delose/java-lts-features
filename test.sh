#!/bin/bash

# Call the environment check script
source ./env.sh

# If the check passes, continue with the rest of the script
echo "Running the main script..."

# Script to run unit tests the project

# Run tests
mvn test

# Check if tests were successful
if [ $? -ne 0 ]; then
  echo "Tests failed. Please check for errors and try again."
  exit 1
fi