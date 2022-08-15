FROM openjdk:11
WORKDIR /application

COPY target/blue-bank-0.0.1-SNAPSHOT.jar /application/api-blue-bank.jar
ENTRYPOINT ["java", "-jar", "api-blue-bank.jar"]

