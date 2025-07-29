FROM openjdk:17-jdk-alpine

WORKDIR /Church

COPY target/Church-0.0.1-SNAPSHOT.jar Church.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Church.jar"]