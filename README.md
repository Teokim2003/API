# API
## Description
Simple CRUD API for Dog Breeds Gallery with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/uncg-csc340/su25-jpa-crud-api.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 17.
- Dependencies to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- `/src/main/resources/application.properties` This file  is the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.

## API Endpoints
Base URL: [`http://localhost:8080/dogs`](http://localhost:8080/dogs)


1. ### [`/`](http://localhost:8080/dogs) (GET)
Gets a list of all dog breeds in the database.

#### Response - A JSON array of Dog objects.

```
[
  {
    "dogId": 1,
    "name": "French Bulldog",
    "desc": "Read more",
    "otherNames": "Bouledogue Français",
    "origin": "France",
  },
  {
    "dogId": 2,
    "name": "Labrador Retriever",
    "desc": "Read more",
    "otherNames": "Labrador",
    "origin": "United Kingdom",
  },
  {
    "dogId": 3,
    "name": "Golden Retriever",
    "desc": "Read more",
    "otherNames": "Flat-coated Retriever, Golden Yellow",
    "origin": "Scotland",
  },
  {
    "dogId": 4,
    "name": "Bulldog",
    "desc": "Read more",
    "otherNames": "English Bulldog, British Bulldog",
    "origin": "England",
  },
  {
    "dogId": 5,
    "name": "Poodle",
    "desc": "Read more",
    "otherNames": "Pudel, Caniche",
    "origin": "Germany",
  }
]
```
