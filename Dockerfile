FROM openjdk:18
WORKDIR /app
COPY ./target/OrderFulfillmentAndConsignmentManagementSystem-0.0.1-SNAPSHOT.jar /app
EXPOSE 1010
CMD ["java", "-jar", "OrderFulfillmentAndConsignmentManagementSystem-0.0.1-SNAPSHOT.jar"]