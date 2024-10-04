#!/bin/bash

# Check if an artifact ID name is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <artifact-id-name>"
  exit 1
fi

ARTIFACT_ID="$1"

# Append the artifact ID to the base package name
BASE_PACKAGE_NAME="com.delose.java.lts"
PACKAGE_NAME="${BASE_PACKAGE_NAME}.${ARTIFACT_ID}"

# Execute the Maven command with the updated package name
mvn archetype:generate \
  -DgroupId="$BASE_PACKAGE_NAME" \
  -DartifactId="$ARTIFACT_ID" \
  -DpackageName="$PACKAGE_NAME" \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

  