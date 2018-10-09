#!/usr/bin/env bash
./wait-for-port.sh $DB_HOST:$DB_PORT -t 15
java -Djava.security.egd=file:/dev/./urandom -jar /statuscode/app.jar --spring.config.location=/statuscode/application.properties