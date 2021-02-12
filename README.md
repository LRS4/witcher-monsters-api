# Spring Boot Monsters REST API

A minimal application to learn the fundamentals of Spring Boot with Java.
The REST API serves data on creatures found in The Witcher 3: Wild Hunt. 
I plan on deploying this backend application to AWS Elastic Beanstalk, and will update
this documentation once it is deployed.

I hope this backend service will help anyone who wants to build a
frontend application of viewing journal entries, similar to the in-game
visual journal:

![Witcher 3 in-game bestiary journal](https://i.imgur.com/BOPSzHl.png "Witcher 3 in-game bestiary")

Disclaimer: This app is for learning purposes, the contents and references
in relation to The Witcher 3: The Wild Hunt are not my own, they belong to CD Projekt Red.

The entry point for the application is within the `/src/main/java/MonstersApplication.java` file.

# REST API - In progress

The REST API endpoints are described below.

## Get list of Monsters

### Request

`GET /monsters/`

    curl -i -H 'Accept: application/json' http://localhost:8080/monsters/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

    []

## Create a new Monster

### Request

`POST /monsters/`

    curl -i -H 'Accept: application/json' -d 'name=Foo&status=new' http://localhost:8080/monsters

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36

    {"id":1,"name":"Foo","status":"new"}

## Get a specific Monster

### Request

`GET /monsters/id`

    curl -i -H 'Accept: application/json' http://localhost:7000/monsters/1

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

    {"id":1,"name":"Foo","status":"new"}

## Get a non-existent Monster

### Request

`GET /monsters/id`

    curl -i -H 'Accept: application/json' http://localhost:7000/monsters/9999

### Response

    HTTP/1.1 404 Not Found
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 404 Not Found
    Connection: close
    Content-Type: application/json
    Content-Length: 35

    {"status":404,"reason":"Monster does not exist"}

### Environment Variables

    DATABASE_URL = The connection URL for the PostGreSQL database
    DATABASE_USER = The username for the PostGreSQL database
    DATABASE_PASSWORD = The password for the PostGreSQL database

[Reference](https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties)

