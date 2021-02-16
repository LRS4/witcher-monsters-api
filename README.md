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

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/monster/panthers

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 1

    [{"id":2,"name":"Panthers","entry":"Pussy cat, pussy cat, where have you been?\nI've been to Cintra to look at the queen\nPussy cat, pussy cat, what did you there?\nRun, fool, that's not a cat but a panther!\n– rare variant of a traditional folk rhyme\n\nPanthers are dangerous predators found in forests and other woodlands. They are quick, agile and, like all cats, diabolically cunning. In many less-than-thoroughly-urbanized areas, folk still believe panthers are the stranded souls of those who die in their sleep. Superstition thus holds anyone perishing in this way should be dragged to the nearest woods and left there without a burial. The panther-spirit of the deceased may then devour its own body, thereby passing on to the nether realms.\nThis belief must be eradicated by any means, for it leads to epidemics of cholera and other contagious diseases born of rotting corpses.\nBesides, it is patently ridiculous, given panthers are not necrophages and will not consume carrion of any sort. They prefer more spry and lively prey, such as deer or even humans, provided they are not ill and do not stink too badly.\nPanthers (and their tawny-coated cousins, mountain lions) are incredibly swift and able to sneak up on prey undetected to gain the advantage of surprise.\nAs soon as they enter open terrain, they leap to attack with astonishing speed, mauling their prey with their sharp claws, long teeth and the sheer force of their momentum.\nPanthers are known to retreat mid-fight, yet do not let yourself be fooled into a false sense of security. This is but a ruse to allow them to attack again, by surprise. Never drop your guard until you see the animal drop dead.\n\nPanthers are vulnerable to the effects of all the Signs, as well as bombs and oils.","imageUrl":"https://static.wikia.nocookie.net/witcher/images/d/da/Tw3_journal_panther.png/revision/latest/scale-to-width-down/350?cb=20160531173331","occurrence":"Toussaint","susceptibility":"Beast oil","loot":"Fur scrap,Cured leather,Raw meat","dateAdded":"2021-02-16","category":{"id":2,"name":"Vampires"}}]

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