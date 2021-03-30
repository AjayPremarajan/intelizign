# intelizign
Keep docker-compose.yml and logstash folder in a separate folder
run docker-compose up -d

Starting point of the micro-service
http://localhost:1234

Sample data:

{

	"productNumber":"C123456",
	"attribute":"1",
	"testStation":"C",
	"result":null
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
Go to CLI of mongo db.Run the following commands.

mongo;
show dbs;

use InspectOrderEventMember;
show collection;
db.eventMember.find().pretty()

use InspectResultEventMember;
show collection;
db.eventMember.find().pretty()




Build:
Make sure java 11 is installed in local machine for maven build
Run mvn_build_all.bat in command prompt to build all projects
Run docker_image_build_all.bat in command prompt to build images for all projects

