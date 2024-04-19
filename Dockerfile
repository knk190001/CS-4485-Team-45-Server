FROM amazoncorretto:17-al2023-headless

ARG ENVIRONMENT=dev
RUN if [ "$ENVIRONMENT" = "prod" ]; then \
        dnf install amazon-cloudwatch-agent -y && \
        /opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a fetch-config -m ec2 -s -c file:/cw-agent.json; \
    fi


VOLUME /tmp
EXPOSE 80
ADD target/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar
ADD cw-agent.json cw-agent.json
ENTRYPOINT ["java","-jar","/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar"]