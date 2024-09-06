#!/bin/bash

# Function to display usage
usage() {
  echo "Usage: $0 <repository_url>"
  exit 1
}

# Check if the repository URL is provided
if [ -z "$1" ]; then
  echo "Error: No repository URL provided."
  usage
fi

REPO_URL=$1

# Set up the remote repository
git remote add origin $REPO_URL
git pull origin main
git add .
git commit -m "init"
git push -u origin main

echo "Remote repository set up at $REPO_URL"
