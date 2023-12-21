FROM ubuntu:latest
LABEL authors="eddie"

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} rabbit-exp.jar

ENTRYPOINT ["java", "-jar", "rabbit-exp.jar"]