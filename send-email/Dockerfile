FROM openjdk:11
ADD send-email/target/send-email-0.0.1-SNAPSHOT.jar send-email.jar
EXPOSE 1238
ENTRYPOINT ["java", "-jar", "send-email.jar"]