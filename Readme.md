![transparent-placeholder](https://imgur.com/yhXhFEt.png)![Logo](https://imgur.com/1Bxir7j.png)

A web application built with Spring Boot and Angular, deployed using Docker Compose.

## Table of Contents

- [Glamify](#glamify)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Features](#features)
  - [Prerequisites](#prerequisites)
  - [Getting Started](#getting-started)
  - [Usage](#usage)
  - [Contributing](#contributing)
  - [License](#license)

## Introduction

This project is a web application that combines the backend functionality of Spring Boot with the frontend user interface built using Angular. It's designed to be easily deployable using Docker Compose, allowing you to run both the backend and frontend in separate containers.

## Features

- Spring Boot backend with RESTful APIs.
- Angular frontend for a user-friendly interface.
- Docker Compose setup for easy deployment.

## Prerequisites

Before you begin, ensure you have the following:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)

## Getting Started

1. Clone this repository:

   ```sh
   git clone https://github.com/Sddilora/Glamify.git
   cd Glamify

   ```

2. Build the Project:

    ```sh
    docker-compose build
    ```

3. Run the Project:

   ```sh
   docker-compose up
   ```

4. Check out what's happening at http://localhost:4200/

![image](https://github.com/user-attachments/assets/5eedcfa7-13f8-403c-9030-82439879c313)

![Screenshot from 2024-08-26 13-58-30](https://github.com/user-attachments/assets/3f59bfae-6747-4344-88ff-21bc90d8ac61)


## Usage

- Customize the frontend and backend according to your project requirements.
- Modify the Docker Compose configuration (docker-compose.yml) as needed.
- Deploy to a production environment using the Docker Compose configuration.

## Contributing

Contributions are welcome! Please follow these guidelines:

- Fork the repository.
- Create a new branch for your feature/bugfix.
- Commit and push your changes.
- Submit a pull request.

## License

MIT License.
