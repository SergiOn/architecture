# Docker


## Links

https://docs.docker.com/network/bridge/

https://docs.docker.com/v17.09/engine/userguide/networking/work-with-networks/

https://docs.docker.com/engine/reference/commandline/tag/


## Commands

#### build

docker build -t "angularjs:$(date -u +'%Y-%m-%d')" .

docker build -t "angular:$(date -u +'%Y-%m-%d')" .

docker build -t "scala-translation:$(date -u +'%Y-%m-%d')" .

docker build -t "nodejs-description:$(date -u +'%Y-%m-%d')" .

docker build -t "java-family:$(date -u +'%Y-%m-%d')" .

docker build -t "java-greeting:$(date -u +'%Y-%m-%d')" .


#### run (check)

docker run -d -p 80:80 angularjs:2019-08-05

docker run -d -p 80:80 angular:2019-08-05

docker run -d -p 80:80 scala-translation:2019-08-05

docker run -d -p 80:80 nodejs-description:2019-08-05

docker run -d -p 80:80 java-family:2019-08-05

docker run -d -p 80:80 java-greeting:2019-08-05


#### run

docker network create -d bridge multi-fe-be

docker network inspect multi-fe-be

docker run --network=multi-fe-be -d -p 4100:80 angularjs:2019-08-05

docker run --network=multi-fe-be -d -p 4200:80 angular:2019-08-05

docker run --network=multi-fe-be --name scala-translation -d scala-translation:2019-08-05

docker run --network=multi-fe-be --name nodejs-description -d nodejs-description:2019-08-05

docker run --network=multi-fe-be --name java-family -d java-family:2019-08-05

docker run --network=multi-fe-be --name java-greeting \
 -e TRANSLATION_SERVICE=scala-translation \
 -e DESCRIPTION_SERVICE=nodejs-description \
 -e FAMILY_SERVICE=java-family \
 -d -p 4300:80 java-greeting:2019-08-05

docker container kill java-greeting java-family nodejs-description scala-translation

docker container rm java-greeting java-family nodejs-description scala-translation


#### tag

| REPOSITORY          | TAG         | IMAGE ID      | CREATED     | SIZE   |
|---------------------|-------------|---------------|-------------|--------|
| scala-translation   | 2019-08-05  | fb7085bc6f49  | 4 days ago  | 128MB  |
| java-greeting       | 2019-08-05  | 756aa2c580c5  | 4 days ago  | 372MB  |
| java-family         | 2019-08-05  | 8794fd57772c  | 4 days ago  | 359MB  |
| nodejs-description  | 2019-08-05  | bda5ff493cf0  | 4 days ago  | 144MB  |
| angular             | 2019-08-05  | f7bc824cf92f  | 4 days ago  | 82.5MB |
| angularjs           | 2019-08-05  | 69f50173f74b  | 4 days ago  | 62.5MB |


docker tag angularjs:2019-08-05 serhiion/angularjs:2019-08-05

docker tag angular:2019-08-05 serhiion/angular:2019-08-05

docker tag scala-translation:2019-08-05 serhiion/scala-translation:2019-08-05

docker tag nodejs-description:2019-08-05 serhiion/nodejs-description:2019-08-05

docker tag java-family:2019-08-05 serhiion/java-family:2019-08-05

docker tag java-greeting:2019-08-05 serhiion/java-greeting:2019-08-05

docker push serhiion/angularjs:2019-08-05

docker push serhiion/angular:2019-08-05

docker push serhiion/scala-translation:2019-08-05

docker push serhiion/nodejs-description:2019-08-05

docker push serhiion/java-family:2019-08-05

docker push serhiion/java-greeting:2019-08-05
