# Kubernetes with AWS, S3 bucket and Kops

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


## Info

docker hub image: serhiion/angularjs-s3:2019-09-22T08-46-39Z

docker hub image: serhiion/angularjs-s3:2019-09-22T08-54-48Z

docker hub image: serhiion/angular-s3:2019-09-22T09-33-08Z

docker hub image: serhiion/angular-s3:2019-09-22T09-50-43Z

docker hub image: serhiion/angular-s3:2019-09-22T13-58-23Z


## Commands

### Kops

ssh serhii@192.168.1.108
password: 1

aws s3api create-bucket --bucket architectso-k8s-bucket --region us-east-1

```json
{
    "Location": "/architectso-k8s-bucket"
}
```

export KOPS_STATE_STORE=s3://architectso-k8s-bucket

HA cluster

kops create cluster architectso-k8s.k8s.local \
      --zones us-east-1a,us-east-1b,us-east-1c,us-east-1d,us-east-1e,us-east-1f \
      --node-count 3 \
      --master-zones us-east-1a,us-east-1b,us-east-1c \
      --yes

kops validate cluster

kubectl get nodes


kops delete cluster architectso-k8s.k8s.local --yes

aws s3 rb s3://architectso-k8s-bucket --force


### Deploy

#### Ingress

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/ingress/mandatory.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/ingress/ingress-l7/ingress-config-map.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/ingress/ingress-l7/ingress-service.yaml


#### Frontend

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angularjs-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angularjs-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angularjs-ingress.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angular-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angular-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angular-ingress.yaml


#### Backend

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/java-family-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/java-family-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/java-greeting-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/java-greeting-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/nodejs-description-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/nodejs-description-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/scala-translation-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/scala-translation-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/backend/backend-ingress-api.yaml


#### Frontend Canary with broken angular

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-deployment.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-ingress.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-deployment-broken.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-service.yaml

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-ingress.yaml


#### Frontend Canary without broken angular

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-deployment.yaml


#### Frontend Canary delete

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-deployment.yaml

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-service.yaml

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angularjs-canary-ingress.yaml

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-deployment.yaml

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-service.yaml

kubectl delete -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/canary/angular-canary-ingress.yaml


#### Frontend Rolling update

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angularjs-deployment-new.yaml --record

kubectl rollout status deployment angularjs-deployment

kubectl rollout history deployment angularjs-deployment


kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angular-deployment-new-broken.yaml --record

kubectl rollout status deployment angular-deployment

kubectl rollout history deployment angular-deployment


#### Frontend Rollout with correct deploy

kubectl rollout undo deployment angular-deployment --to-revision=1

kubectl apply -f https://raw.githubusercontent.com/SergiOn/architecture/master/multi-frontend-backend-cloud/kubernetes-aws-s3-kops/frontend/angular-deployment-new.yaml --record

kubectl rollout history deployment angular-deployment

kubectl get pods -o wide

kubectl top node

kubectl top pod


### Kops destroy

kubectl delete deployment --all

kubectl delete services --all


kops delete cluster architectso-k8s.k8s.local --yes

aws s3 rb s3://architectso-k8s-bucket --force

