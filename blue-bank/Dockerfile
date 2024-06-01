# Etapa de construção
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app

# Copiar os arquivos do projeto para a imagem
COPY . /app

# Compilar e empacotar o projeto usando Maven
RUN mvn clean install

# Etapa final
FROM openjdk:11-jdk-slim
WORKDIR /app

# Copiar o JAR empacotado da etapa de construção
COPY --from=build /app/target/blue-bank-0.0.1-SNAPSHOT.jar /app/api-blue-bank.jar

ENV SPRING_PROFILES_ACTIVE=dev

# Definir o ponto de entrada para a aplicação
ENTRYPOINT ["java", "-jar", "api-blue-bank.jar", "-Dspring.profiles.active=dev"]


