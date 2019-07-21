FROM openjdk:8-alpine

ENV HOST 0.0.0.0
#ENV HOST 127.0.0.1
#ENV HOST "localhost"
ENV PORT 80

WORKDIR /usr/src/app

COPY ./target/scala-2.13/*.jar ./scala-translation.jar

EXPOSE $PORT

CMD ["java", "-jar", "scala-translation.jar"]
