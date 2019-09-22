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




