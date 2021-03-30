# intelizign
Keep docker-compose.yml and logstash folder in a separate folder
run docker-compose up -d

Starting point of the micro-service
http://localhost:1234/swagger-ui.html

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
Go to CLI of mongo db
show dbs;
use datbase_name
show collection
db.employee.find().pretty()