FROM openjdk:8-jdk-alpine
MAINTAINER gustavopeiretti.com <gustavopeiretti.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/springbootdocker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/com/./urandom","-jar","/app.jar"]