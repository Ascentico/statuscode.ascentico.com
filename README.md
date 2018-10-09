#Status Code

This REST API serves information about HTTP status codes.

## Build Status

[![Build Status](https://travis-ci.org/Ascentico/statuscode.ascentico.com.svg?branch=master)](https://travis-ci.org/Ascentico/statuscode.ascentico.com)
[![Coverage Status](https://coveralls.io/repos/github/Ascentico/statuscode.ascentico.com/badge.svg?branch=master)](https://coveralls.io/github/Ascentico/statuscode.ascentico.com?branch=master)
[![Docker Automated build](https://img.shields.io/docker/automated/jrottenberg/ffmpeg.svg)](https://hub.docker.com/r/ascentico/statuscode/)


## Running

### Docker Container

If you have an existing PostgreSQL server that you'd like to use create a new user and database on it and use the following: 

`docker run --publish 8080:8080 --env DB_HOST="<your-postgres-server>" --env DB_PORT="<your-postgres-server-port>" --env DB_USERNAME="<username>" --env DB_PASSWORD="<password>" --env DB="<database>" ascentico/statuscode
`

You should now be able to access the REST API via 8080:/api/v1/

### Running as a Spring Boot Application

Set the following configuration in the application.properties to suite your environment:

`spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://<your-postgres-server>/<database>
spring.datasource.username=<username>
spring.datasource.password=<password>`

Then run jar ensuing the .properties file is accessible.