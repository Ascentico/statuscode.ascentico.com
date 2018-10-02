#!/usr/bin/env bash
./wait-for-port.sh db:5432 -t 15
java -Djava.security.egd=file:/dev/./urandom -jar /statuscode/app.jar --spring.config.location=/statuscode/application.properties