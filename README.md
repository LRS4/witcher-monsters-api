# Spring Boot Monsters REST API

A minimal application to learn the fundamentals of Spring Boot with Java.
The REST API serves data on creatures found in The Witcher 3: Wild Hunt. 
This is bundled with an Angular application served from Spring Boot's 
resources/static folder which will act as the UI. The application is deployed
to AWS Elastic Beanstalk using CD/CD best practices with AWS CodePipeline and CodeBuild.

The frontend application can be accessed at: 
[http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com](http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com)

I hope the API will help anyone who wants to build a
frontend application of viewing journal entries, similar to the in-game
visual journal:

![Witcher 3 in-game bestiary journal](https://i.imgur.com/BOPSzHl.png "Witcher 3 in-game bestiary")

Disclaimer: This app is for learning purposes, the contents and references
in relation to The Witcher 3: The Wild Hunt are not my own, they belong to CD Projekt Red.
The image URLs are from [witcher.fandom.com](https://witcher.fandom.com/wiki/The_Witcher_3_bestiary)
which is licensed under the Creative Commons Attribution-Share Alike License 3.0 (Unported) (CC-BY-SA).

The entry point for the application is within the `/src/main/java/MonstersApplication.java` file.

# Base URL

`GET http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com`

# REST API

The REST API endpoints are described below. Spaces are hyphenated
for database indexing.

## Get list of Monsters

### Request

`GET /api/v1/monster/`

    curl -i -H 'Accept: application/json' http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com/api/v1/monster/

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

`GET /api/v1/monster/category/vampires`

    curl -i -H 'Accept: application/json' http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com/api/v1/monster/category/vampires

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

`GET /api/v1/monster/ice-elemental`

    curl -i -H 'Accept: application/json' http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com/api/v1/monster/ice-elemental

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

`GET /api/v1/monster/non-existent-monster`

    curl -i -H 'Accept: application/json' http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com/api/v1/monster/non-existent-monster

### Response

    HTTP/1.1 404 Not Found
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 404 Not Found
    Connection: close
    Content-Type: application/json
    Content-Length: 35

    {"status":404,"reason":"Monster with name non-existent-monster does not exist."}

## Get all Monster categories

### Request

`GET /api/v1/monster/categories/all`

    curl -i -H 'Accept: application/json' http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com/api/v1/monster/categories/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 3

    [{"id":1,"name":"beasts","displayName":"Beasts"},{"id":2,"name":"cursedones","displayName":"Cursed Ones"},{"id":3,"name":"elementa","displayName":"Elementa"}]

## Admin Requests

The following requests are for admin API key holders only.
These requests were documented using Postman.

## Create a new Monster

Creating a new monster follows the convention of adding
a monster to a category. An example of this can be seen
below adding Wild Boars to the Beasts category.

### Request

`POST /api/v1/monsters/category/beasts`

`HEADERS x-api-key {ADMIN_API_KEY}`

    {
        {
        "name": "wild-boars",
        "displayName": "Wild boars",
        "entry": "How doth the little wild boar\n Improve his shining tusks,\n And rut them 'gainst the forest floor,\n And on the trees' rough husks!\n How cheerfully he seems to grin\n How neatly spreads his claws,\n And welcomes little lasses in,\n With gently smiling jaws!\n Louis of Charolle, mathematician, author and poet\n\n These woodland beasts are as \"wild\" – untamed, nasty and aggressive – as their name indicates. To this day, many peasants in outlying Kaedweni villages believe wild boars persist on a diet of young maids, though in truth they most often slate their hunger with roots and acorns. Do not think this vegetarian diet makes them harmless, however. In fact, these animals' stout build and sharp teeth render them veritable fur-covered combat machines. Mother Nature has additionally equipped them with dual pairs of tusks - upper \"pipes\" and lower \"sabres\" - and this weaponry's sum effect is to make the beasts the terrors of the woods, a threat to all who venture or dwell there, human, humanoid and otherwise. Boars also have hard, club-like snouts, which some peasants call their \"whistles,\" though no boar has ever been heard to make such a noise. Instead, they emit a characteristic grunt, which sounds to some like the snoring of an extremely overweight man. Another peasant belief claims boars have extremely prickly natures, and, if offended, will vent their anger by knocking down fences and gobbling up potatoes. Though they sometimes live alone, boars usually appear in small groups of 3 to 5 specimens.",
        "imageUrl": "https://static.wikia.nocookie.net/witcher/images/9/93/Tw3_journal_wild_boar.png/revision/latest/scale-to-width-down/350?cb=20170501180811",
        "occurrence": "Gustfields,Toussaint",
        "susceptibility": "Northern Wind,Beast oil,Igni,Yrden",
        "loot": "Boar tusk,Boar pelt,Raw meat"
    }

### Response

    "Monster Wild boars added."

    OR

    {"status":500,"reason":"Monster already exists."}

    OR 

    {"status":500,"reason":"Category with name madeupCategory is invalid.
                    "/api/v1/monster/categories/all returns valid category names."}

    OR

    {"status":500,"reason":"Admin API key is invalid./must be provided"}

## Update existing monster

Updating an existing monster follows the convention of
providing a monster ID and a category ID alongside the
monster object. A field which differs from the
currently assigned value will be changed including
the category. 

### Request

`PUT /api/v1/monsters/5/9`

`HEADERS x-api-key {ADMIN_API_KEY}`

    {
        {
        "name": "wild-boars",
        "displayName": "Wild boars",
        "entry": "How doth the little wild boar\n Improve his shining tusks,\n And rut them 'gainst the forest floor,\n And on the trees' rough husks!\n How cheerfully he seems to grin\n How neatly spreads his claws,\n And welcomes little lasses in,\n With gently smiling jaws!\n Louis of Charolle, mathematician, author and poet\n\n These woodland beasts are as \"wild\" – untamed, nasty and aggressive – as their name indicates. To this day, many peasants in outlying Kaedweni villages believe wild boars persist on a diet of young maids, though in truth they most often slate their hunger with roots and acorns. Do not think this vegetarian diet makes them harmless, however. In fact, these animals' stout build and sharp teeth render them veritable fur-covered combat machines. Mother Nature has additionally equipped them with dual pairs of tusks - upper \"pipes\" and lower \"sabres\" - and this weaponry's sum effect is to make the beasts the terrors of the woods, a threat to all who venture or dwell there, human, humanoid and otherwise. Boars also have hard, club-like snouts, which some peasants call their \"whistles,\" though no boar has ever been heard to make such a noise. Instead, they emit a characteristic grunt, which sounds to some like the snoring of an extremely overweight man. Another peasant belief claims boars have extremely prickly natures, and, if offended, will vent their anger by knocking down fences and gobbling up potatoes. Though they sometimes live alone, boars usually appear in small groups of 3 to 5 specimens.",
        "imageUrl": "https://static.wikia.nocookie.net/witcher/images/9/93/Tw3_journal_wild_boar.png/revision/latest/scale-to-width-down/350?cb=20170501180811",
        "occurrence": "Gustfields,Toussaint",
        "susceptibility": "Northern Wind,Beast oil,Igni,Yrden",
        "loot": "Boar tusk,Boar pelt,Raw meat"
    }

### Response

    "Monster with ID 5 updated."

    OR

    {"status":500,"reason":"Monster with ID 5 does not exist.."}

    OR 

    {"status":500,"reason":"Category with ID 9 is invalid.
                    "/api/v1/monster/categories/all returns valid category IDs."}

    OR

    {"status":500,"reason":"Admin API key is invalid./must be provided"}

## Delete existing monster

### Request

`PUT /api/v1/monsters/5`

`HEADERS x-api-key {ADMIN_API_KEY}`

### Response

    "Monster with ID 5 deleted."

    OR

    {"status":500,"reason":"Monster with ID 5 does not exist."}

    OR

    {"status":500,"reason":"Admin API key is invalid./must be provided"}

### Environment Variables

    DATABASE_URL = The connection URL for the PostGreSQL database
    DATABASE_USER = The username for the PostGreSQL database
    DATABASE_PASSWORD = The password for the PostGreSQL database
    MONSTERS_API_ADMIN_KEY = The key for admin users. Secures the add new and update existing routes against the x-api-key auth header.
    SERVER_PORT = 5000

[Reference](https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties)

### Useful Resources

* [Spring Boot Tutorial](https://www.youtube.com/watch?v=9SGDpanrc8U)
* [Spring Data JPA Many to One](https://www.youtube.com/watch?v=_Jnu_jHfQbM)
* [Handle Hibernate transient instance](https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save)
* [Hikari Database Connection Settings](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby)
* [Invalidate cache and reload in IntelliJ](https://stackoverflow.com/questions/52091449/class-not-found-in-module-warning-when-try-to-create-run-debug-configuration-in)
* [Angular and Spring Boot Integration](https://www.youtube.com/watch?v=JJoBUdMJf1I)
* [Deploy Spring Boot to AWS Elastic Beanstalk](https://www.youtube.com/watch?v=6SadWaJrtnY)
* [Configure CD/CD using AWS CodePipeline and CodeBuild](https://www.youtube.com/watch?v=agDw-Ak4lAI&t=315s)
* [Artifact JAR must be top level for Elastic Beanstalk](https://stackoverflow.com/questions/60840569/aws-codepipeline-deploy-spring-boot-application-to-elastic-beanstalk)
* [Adding unit tests and mocks](https://www.youtube.com/watch?v=kXhYu939_5s)
* [Testing Web Controller HTTP](https://reflectoring.io/spring-boot-web-controller-test/)
* [REST API controller unit testing](https://www.youtube.com/watch?v=RbZvXCAtMus)
* [Unit testing with Spring MVC](https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/)
* [Preventing CommandLineRunner during tests](https://www.baeldung.com/spring-junit-prevent-runner-beans-testing-execution)
* [Spring Boot Tutorial](https://www.springboottutorial.com)