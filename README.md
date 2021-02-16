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

The REST API endpoints are described below. Spaces are hyphenated
for database indexing.

## Get list of Monsters

### Request

`GET /api/v1/monster/`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/monster/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 3

    [{ Monster }, { Monster }, { Monster } ...]

## Get list of Monsters by Category

### Request

`GET /api/v1/monster/category/{name}`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/monster/category/vampires

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 3

    [{ Monster }, { Monster }, { Monster } ...]

## Get a specific Monster

### Request

`GET /api/v1/monster/{name}`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/monster/ice-elemental

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 1

    [{"id":5,"name":"ice-elemental","displayName":"Ice Elemental","entry":"I thought to myself - what's a hunk of ice doing in the middle of some lab? And then that hunk of ice got up and broke my legs.\n– Yannick Lovt, burglar\nAn ice elemental is a mass of frozen water animated by magic. Deprived of consciousness or independent will, this elemental is boundlessly obedient to the orders of the mage who created it. Those orders usually contain but one syllable: kill.\nIce elementals have no qualms about carrying out this order nor any particular difficulty in doing so. Gifted with incredible strength, they are completely invulnerable to poison and fire, deprived of sensitive organs, hard as permafrost and all in all incredibly difficult opponents. A witcher's only chance at tipping the scales towards victory is to toss a dimeritium bomb – shrapnel made of this metal interferes with the workings of the spell that gives this creature life. Beyond that remains only prayer.","imageUrl":"https://static.wikia.nocookie.net/witcher/images/c/c6/Tw3_journal_iceelemental.png/revision/latest/scale-to-width-down/350?cb=20160409141539","occurrence":"Skellige","susceptibility":"Dimeritium bomb,Elementa oil","loot":"Elemental essence","dateAdded":"2021-02-16","category":{"id":3,"name":"elementa","displayName":"Elementa"}}]

## Get a non-existent Monster

### Request

`GET /api/v1/monster/{name}`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/monster/gargoyle

### Response

    HTTP/1.1 404 Not Found
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 404 Not Found
    Connection: close
    Content-Type: application/json
    Content-Length: 35

    {"status":404,"reason":"Monster with name gargoyle does not exist."}

## Admin Requests

The following requests are for admin API key holders only.
These requests were documented using Postman.

## Create a new Monster

### Request

`POST /api/v1/monsters/`

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36

    {"id":1,"name":"Foo","status":"new"}

### Environment Variables

    DATABASE_URL = The connection URL for the PostGreSQL database
    DATABASE_USER = The username for the PostGreSQL database
    DATABASE_PASSWORD = The password for the PostGreSQL database
    MONSTERS_API_ADMIN_KEY = The key for admin users. Secures the add new and update existing routes against the x-api-key auth header.

[Reference](https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties)

### Useful Resources

* [Spring Boot Tutorial](https://www.youtube.com/watch?v=9SGDpanrc8U)
* [Spring Data JPA Many to One](https://www.youtube.com/watch?v=_Jnu_jHfQbM)
* [Handle Hibernate transient instance](https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save)