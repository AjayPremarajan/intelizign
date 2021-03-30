# intelizign
Keep docker-compose.yml and logstash folder in a separate folder
run docker-compose up -d

Starting point of the micro-service
http://localhost:1234

Sample data:

{
	"productNumber":"C123456",
	"attribute":"1",
	"testStation":"C"
}

Sample output:

{
  "responseCode": "200",
  "responesMessage": "Sucessfully message processed and event created",
  "eventId": "52e77918-9fff-4785-9006-6844eec32631"
}

logs:

ELK stack is running in the docker collecting logs from microservices

Kibana can be accessed at the below url

http://localhost:5601/


database:
Go localhost:8888 and login with admin@admin.com with password as admin
Create a server with postgres as host and port 5432 with username and password inspect_db

Build:
Make sure java 11 is installed in local machine for maven build else build maven using IDE. The Dockerfile will have path to be run from main folder.
Running Dockerfile locally, run it one level up. Ex: docker build -f sap-adapter/Dockerfile -t ajaypremarajan/sap-adapter .

Run mvn_build_all.bat in command prompt to build all projects
Run docker_image_build_all.bat in command prompt to build images for all projects

If you want both maven build and image build run buildMavenDockerImage.bat in command prompt

Starting Docker containers:
docker-compose up -d
Stopping Docker containers:
docker-compose down

