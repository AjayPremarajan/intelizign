@echo off 
call echo "------------------------------------------Starting maven build for all microservices------------------------------------------"
call mvn clean install -f inspect-order\pom.xml
call mvn clean install -f inspect-result\pom.xml
call mvn clean install -f sap-adapter\pom.xml
call mvn clean install -f send-email\pom.xml
call mvn clean install -f test-station\pom.xml
call echo "------------------------------------------Finished maven build for all microservices------------------------------------------"