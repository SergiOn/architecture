FROM openjdk:12-alpine

ENV PORT 80

WORKDIR /usr/src/app

COPY ./build/libs/*.jar ./java-family.jar

EXPOSE $PORT

CMD ["java", "-jar", "java-family.jar"]
