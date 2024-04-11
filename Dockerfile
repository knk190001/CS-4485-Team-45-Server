FROM eclipse-temurin:17-jdk-alpine
RUN apk add curl
VOLUME /tmp
EXPOSE 80
ADD target/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar"]