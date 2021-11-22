#!/bin/sh
mvn clean package && docker build -t ch.lab.Unil/EventWebsite .
docker rm -f EventWebsite || true && docker run -d -p 9080:9080 -p 9443:9443 --name EventWebsite ch.lab.Unil/EventWebsite