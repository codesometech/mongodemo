FROM openjdk:8-jdk-alpine
LABEL maintainer="pravnere@amazon.com"
VOLUME /tmp
ARG JAR_FILE=target/mongodemo*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.config.location=classpath:/application.properties"]
