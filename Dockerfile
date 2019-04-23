
FROM openjdk:8

LABEL maintainer="naman11396@gmail.com"

VOLUME /tmp
EXPOSE 8087

ARG WAR_FILE=target/ComplaintPortal19-0.0.1-SNAPSHOT.war

ADD ${WAR_FILE} ComplaintPortal19-0.0.1-SNAPSHOT.war

ENTRYPOINT ["java","-jar","/ComplaintPortal19-0.0.1-SNAPSHOT.war"]