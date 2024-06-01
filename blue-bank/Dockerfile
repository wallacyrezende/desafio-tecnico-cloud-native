FROM bellsoft/liberica-openjdk-alpine:11
WORKDIR /application

COPY target/blue-bank-0.0.1-SNAPSHOT.jar /application/api-blue-bank.jar
ENV SPRING_PROFILES_ACTIVE=dev
ENTRYPOINT ["java", "-jar", "api-blue-bank.jar"]

