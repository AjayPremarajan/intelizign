FROM openjdk:11
ADD test-station/target/test-station-0.0.1-SNAPSHOT.jar test-station.jar
EXPOSE 1236
ENTRYPOINT ["java", "-jar", "test-station.jar"]