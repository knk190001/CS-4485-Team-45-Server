FROM amazoncorretto:17-al2023-headless

ARG ENVIRONMENT=dev
#RUN if [ "$ENVIRONMENT" = "prod" ]; then \
#        dnf install amazon-cloudwatch-agent -y;\
#    fi

VOLUME /tmp
EXPOSE 80
ADD target/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar
#ADD cw-agent.json cw-agent.json
#CMD /bin/sh -c 'if [ $ENVIRONMENT = "prod" ]; then \
#        /opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a fetch-config -m ec2 -c file:/cw-agent.json -s; \
#    fi'

ENTRYPOINT ["java","-jar","/CS-4485-Team-45-Server-0.0.1-SNAPSHOT.jar"]