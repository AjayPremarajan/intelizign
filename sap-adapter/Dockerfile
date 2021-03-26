FROM openjdk:11
ADD target/sap-adapter-0.0.1-SNAPSHOT.jar sap-adapter.jar
EXPOSE 1234
ENTRYPOINT ["java", "-jar", "sap-adapter.jar"]