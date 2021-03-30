FROM openjdk:11
ADD inspect-order/target/inspect-order-0.0.1-SNAPSHOT.jar inspect-order.jar
EXPOSE 1235
ENTRYPOINT ["java", "-jar", "inspect-order.jar"]