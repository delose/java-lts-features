#!/bin/bash

# Check if an artifact ID name is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <artifact-id-name>"
  exit 1
fi

ARTIFACT_ID="$1"

# Execute the Maven command with the provided artifact ID
mvn archetype:generate \
  -DgroupId=com.delose.java.lts \
  -DartifactId="$ARTIFACT_ID" \
  -DpackageName=com.delose.java.lts \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false


