FROM amazoncorretto:17-al2023-headless
VOLUME /tmp
EXPOSE 80
ADD target/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar"]