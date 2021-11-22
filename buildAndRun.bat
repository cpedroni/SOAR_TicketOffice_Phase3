@echo off
call mvn clean package
call docker build -t ch.lab.Unil/EventWebsite .
call docker rm -f EventWebsite
call docker run -d -p 9080:9080 -p 9443:9443 --name EventWebsite ch.lab.Unil/EventWebsite