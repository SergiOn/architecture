# Docker


## Links

https://docs.docker.com/network/bridge/

https://docs.docker.com/v17.09/engine/userguide/networking/work-with-networks/


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
