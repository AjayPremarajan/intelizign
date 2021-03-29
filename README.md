# intelizign
Keep docker-compose.yml and logstash folder in a separate folder
run docker-compose up -d

Starting point of the microservice
http://localhost:1234/swagger-ui.html#!/sap-adapter-controller/processUsingPOST


Sample data:

{

	"productNumber":"C123456",
	"attribute":"1",
	"testStation":"C",
	"result":true
}

Sample output:

{
  "responseCode": "200",
  "responesMessage": "Sucessfully message processed and event created",
  "eventId": "52e77918-9fff-4785-9006-6844eec32631"
}
