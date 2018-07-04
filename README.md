# YaMD

Yet Another Movie Database.

Spring Boot REST Service to obtain movie information.


| HTTP Method | URI |Description |
| --- | --- | --- |
| POST | `/user/sign-up` | Register a new user |
| POST | `/login` | Logs into the application (JWT is generated) |
| GET | `/api/v1/movies` | Return a list of movies |
| GET | `/api/v1/movies/id={movie_id}` | Return a specific movie |
| GET | `/api/v1/movies/t={title)` | Return a list of movies with given title (ignore case) |
| GET | `/api/v1/movies/count` | Return the number of movies in the database |
| POST | `/api/v1/movies` | Create a new movie |
| PUT | `/api/v1/movies` | Update a movie |

Remember to fill header Authorization with the retrieved JWT, example:

    GET http://localhost:8080/v1/movies
    Content-Type: application/json
    Authorization: YaMD xxxx.yyyy.zzzz

[More examples](./src/main/java/pl/b2bnetwork/Example.http)



## Tested on

- Java SE Development Kit 8
- Spring Boot 1.5.13
- Maven 3.0+
- MySQL 5.0+ _(prod db - should work with any other relational database, but you need to change dependency)_
- H2 1.4+ _(dev db)_
- JJWT 0.7


## Getting Started

If you want to run this app on production import the Maven project straight to your Java IDE, change **_spring.profiles.active_** to **_prod_**,  create database with name _moviedb_ and change db credientials in **_[application.properties](./src/main/resources/application.properties)_**.