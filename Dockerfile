FROM eclipse-temurin:15-jdk-alpine
VOLUME /temp
ARG JAR_FILE=target/conversionsystem-0.0.1-SNAPSHOT.jar
EXPOSE 80
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

