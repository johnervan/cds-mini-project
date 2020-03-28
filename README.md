# CDS Mini Project

## Software Requirements
1. [Java 8 JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
2. [Postgres](https://www.postgresql.org/download/)

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
