## Backend

There are Java and NodeJS in this side.


#### Technologies

Java, Spring, NodeJS, Express, Scala, Akka, Docker


#### Links

https://medium.com/javascript-in-plain-english/typescript-with-node-and-express-js-why-when-and-how-eb6bc73edd5d

https://github.com/microsoft/TypeScript-Node-Starter

https://www.typescriptlang.org/docs/handbook/module-resolution.html

https://github.com/Microsoft/TypeScript/issues/29272

https://nodejs.org/api/modules.html#modules_loading_from_the_global_folders

https://stackoverflow.com/questions/42964102/syntax-for-async-arrow-function

https://expressjs.com/en/guide/routing.html


https://developer.lightbend.com/guides/akka-http-quickstart-scala/index.html

https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html

https://alvinalexander.com/scala/sbt-how-to-compile-run-package-scala-project

https://stackoverflow.com/questions/15203113/creating-an-akka-fat-jar

https://github.com/sbt/sbt-assembly

https://doc.akka.io/docs/akka-http/current/routing-dsl/directives/route-directives/complete.html

https://stackoverflow.com/questions/9997292/how-to-read-environment-variables-in-scala

https://stackoverflow.com/questions/43868405/string-parameters-using-akka-http-directives-during-get-requests

https://hub.docker.com/_/openjdk

https://stackoverflow.com/questions/37760999/docker-akka-http-application-endpoint-not-reachable


https://stackoverflow.com/questions/42751269/feign-logging-not-working


#### Commands

docker build -t nodejs-description .

docker run -p 4302:80 nodejs-description

docker run -d -p 4302:80 nodejs-description

docker container ls

docker build -t "nodejs-description:$(date -u +'%Y-%m-%dT%H-%M-%SZ')H$(git log -1 --pretty=%h)" .

docker container run -d -p 4302:80 nodejs-description:2019-07-19T18-22-11ZH7466043

docker image ls

docker container ls


sbt compile

sbt package

sbt assembly

docker build -t scala-translation .

docker run -p 4301:80 scala-translation

docker build -t "scala-translation:$(date -u +'%Y-%m-%dT%H-%M-%SZ')H$(git log -1 --pretty=%h)" .

docker run -d -p 4301:80 scala-translation:2019-07-21T00-03-27ZH5b3420c


docker build -t java-family .

docker run -p 4303:80 java-family

docker build -t "java-family:$(date -u +'%Y-%m-%dT%H-%M-%SZ')H$(git log -1 --pretty=%h)" .

docker run -d -p 4303:80 java-family:2019-07-21T13-48-07ZH5938abd
