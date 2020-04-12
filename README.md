# CDS Mini Project

## Software Requirements
1. [Java 8 JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
2. [Postgres](https://www.postgresql.org/download/)
3. [Postman](https://www.postman.com/downloads/) - For API Documentation and Testing

Note: Development Environment has only be tested on Mac OS and Linux Distributions

## Quick Start
1. Git clone repository
    ```bash
    git clone https://github.com/johnervan/cds-mini-project.git
    ```
2. Navigate to directory
    ```bash
    cd cds-mini-project
    ```
3. Create Environment File
    ```bash
    cp .env.example .env
    ```
4. Modify Environment values in .env file (optional)
5. Bootstrap Database
    ```bash
   sh setup.sh
    ```
6. Start Server (1st run may take a while because dependencies will be downloaded)
    ```bash
   sh server.sh
    ```
7. Server will be listening on Port 8080 (i.e. http://localhost:8080)

## Consuming the APIs
There are three APIs available in the project. The postman collection can be found [here](/docs/CDS%20Mini%20Project.postman_collection.json).
1. GET /api/users - Get all users and their salaries
2. POST /api/users - Create a single user and his/her salary
3. POST /api/users/upload - Upload multiple users and their respective salaries using CSV. Sample CSV can be found [here](/samples/data.csv).

## Acknowledgements
This project was bootstrapped with [spring initializr](https://start.spring.io/). Structure and code style of this Springboot project was also heavily influenced by [Khandewal Arpit](https://github.com/khandelwal-arpit)'s [springboot-starterkit](https://github.com/khandelwal-arpit/springboot-starterkit).
