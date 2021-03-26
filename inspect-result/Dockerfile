FROM openjdk:11
ADD target/inspect-result-0.0.1-SNAPSHOT.jar inspect-result.jar
EXPOSE 1237
ENTRYPOINT ["java", "-jar", "inspect-result.jar"]