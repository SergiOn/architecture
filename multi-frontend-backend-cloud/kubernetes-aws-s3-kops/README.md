# Kubernetes with AWS and Kops

version: 1.12.3


## Links

https://docs.aws.amazon.com/en_us/AmazonS3/latest/dev/website-hosting-custom-domain-walkthrough.html

https://docs.aws.amazon.com/en_us/AmazonS3/latest/dev/cors.html

https://s3.console.aws.amazon.com/s3/buckets/frontend-cloud-s3


## Actions

create s3 bucket: frontend-cloud-s3

create folders: angularjs, angular

url: https://frontend-cloud-s3.s3.amazonaws.com/angularjs/

url: https://frontend-cloud-s3.s3.amazonaws.com/angular/


## Commands

#### AngularJS

docker build -t "angularjs-s3:$(date -u +'%Y-%m-%dT%H-%M-%SZ')" .

docker container run -d -p 4100:80 angularjs-s3:2019-09-22T08-46-39Z

docker container run -d -p 4100:80 angularjs-s3:2019-09-22T08-54-48Z

v1: angularjs-s3:2019-09-22T08-46-39Z

v2: angularjs-s3:2019-09-22T08-54-48Z


#### Angular

docker build -t "angular-s3:$(date -u +'%Y-%m-%dT%H-%M-%SZ')" .

docker container run -d -p 4200:80 angular-s3:2019-09-22T09-33-08Z

docker container run -d -p 4200:80 angular-s3:2019-09-22T09-50-43Z

v1: angular-s3:2019-09-22T09-33-08Z

v2: angular-s3:2019-09-22T09-50-43Z

