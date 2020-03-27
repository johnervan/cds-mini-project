#!/bin/sh
source .env
ECHO "Loaded Environment Variables"
./mvnw spring-boot:run
