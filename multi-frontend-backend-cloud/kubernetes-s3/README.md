# Kubernetes with AWS S3 bucket


## Links

https://docs.aws.amazon.com/en_us/AmazonS3/latest/dev/website-hosting-custom-domain-walkthrough.html

https://docs.aws.amazon.com/en_us/AmazonS3/latest/dev/cors.html

https://s3.console.aws.amazon.com/s3/buckets/frontend-cloud-s3

https://stackoverflow.com/questions/48077931/delete-all-the-contents-from-a-kubernetes-node


## Actions

create s3 bucket: frontend-cloud-s3

create folders: angularjs, angular

url: https://frontend-cloud-s3.s3.amazonaws.com/angularjs/

url: https://frontend-cloud-s3.s3.amazonaws.com/angular/


## Info

docker hub image, angularjs v1: serhiion/angularjs-s3:2019-09-22T08-46-39Z

docker hub image, angularjs v2: serhiion/angularjs-s3:2019-09-22T08-54-48Z

docker hub image, angular v1: serhiion/angular-s3:2019-09-22T09-33-08Z

docker hub image, angular v2-broken: serhiion/angular-s3:2019-09-22T09-50-43Z

docker hub image, angular v2: serhiion/angular-s3:2019-09-22T13-58-23Z


## Commands

kubectl delete deployment --all

kubectl delete services --all

minikube delete

minikube start --cpus=2 --memory='12gb'

cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-s3

kubectl apply -f 

minikube ip
192.168.99.106

kubectl get pods

kubectl get services

kubectl get pods --watch

find . -name "*.yaml" -exec echo {} \;

find . -name "*.yaml" -exec kubectl apply -f {} \;

find . -name "angular-*" -exec echo {} \;

find . -name "angular-*" -exec kubectl apply -f {} \;


### Rolling update

kubectl rollout status deployment angular-deployment

kubectl rollout status deployment angularjs-deployment


kubectl rollout history deployment angular-deployment

kubectl rollout history deployment angularjs-deployment


kubectl apply -f angular-deployment-new-broken.yaml --record

kubectl apply -f angularjs-deployment-new.yaml --record


kubectl rollout status deployment angular-deployment

kubectl rollout status deployment angularjs-deployment


kubectl rollout history deployment angular-deployment

kubectl rollout history deployment angularjs-deployment


kubectl rollout history deployment angular-deployment

kubectl rollout undo deployment angular-deployment --to-revision=1


kubectl apply -f angular-deployment-new.yaml --record

