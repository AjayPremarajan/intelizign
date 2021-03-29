# intelizign
Run the docker-compose file to orchestra the entire microservice

Starting point of the microservice
http://localhost:1234/swagger-ui.html#!/sap-adapter-controller/processUsingPOST


Logging service
http://localhost:1233/swagger-ui.html#!/logging-service-controller/getLogsUsingGET

If you send "clear" string in the request of logging service the request queue is cleared from memory


Sample data:

{

	"productNumber":"C123456",
	"attribute":"1",
	"testStation":"C",
	"result":true
}

If result is sent null, then random value is assigned upon which send-email microservice call is decided
productNumber should atleast have an alphabet in it for the application logic to work
