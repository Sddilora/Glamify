### STAGE 1: Build ###
FROM maven:3.8.1-jdk-11-slim AS build
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -f pom.xml clean package -DskipTests

### STAGE 2: Run ###
FROM openjdk:11.0.7-jre-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]