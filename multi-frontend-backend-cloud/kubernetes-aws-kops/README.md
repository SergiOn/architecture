# Kubernetes with AWS and Kops

version: 1.12.3


## Links

https://github.com/kubernetes/kops

https://v1-12.docs.kubernetes.io/docs/tasks/tools/install-kubectl/

https://www.udemy.com/course/draft/1522024/learn/lecture/9630348#overview

https://www.youtube.com/watch?v=RZwb6hhZvqM

https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html

https://docs.aws.amazon.com/cli/latest/userguide/install-linux.html

https://linuxize.com/post/how-to-install-python-3-7-on-ubuntu-18-04/

https://linuxize.com/post/how-to-install-pip-on-ubuntu-18.04/

https://linuxize.com/post/how-to-enable-ssh-on-ubuntu-18-04/

https://www.ssh.com/ssh/copy-id

https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html

https://docs.aws.amazon.com/cli/latest/reference/s3api/create-bucket.html

https://docs.aws.amazon.com/AmazonS3/latest/dev/delete-or-empty-bucket.html#targetText=Delete%20a%20Bucket%3A%20Using%20the%20AWS%20CLI&targetText=If%20your%20bucket%20does%20not,and%20then%20deletes%20the%20bucket.

https://github.com/kubernetes/kops/blob/master/docs/aws.md

https://askubuntu.com/questions/9800/remote-host-identification-has-changed-warning-when-connecting-over-ssh

https://www.youtube.com/watch?v=gEzCKNA-nCg


## Commands

ssh serhii@192.168.1.108

curl -LO https://github.com/kubernetes/kops/releases/download/$(curl -s https://api.github.com/repos/kubernetes/kops/releases/latest | grep tag_name | cut -d '"' -f 4)/kops-linux-amd64

curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.12.9/bin/linux/amd64/kubectl

chmod +x ./*

pip3 install awscli --upgrade --user

pip3 install awscli

aws --version

pip3 list -o


sudo apt install openssh-server

ip a
192.168.1.108

sudo ssh serhii@192.168.1.108

sudo ssh-copy-id -i ~/.ssh/id_rsa serhii@192.168.1.108


aws configure

Default region name [None]: us-east-1


aws s3api create-bucket --bucket architectso-k8s-bucket --region us-east-1

```json
{
    "Location": "/architectso-k8s-bucket"
}
```

export KOPS_STATE_STORE=s3://architectso-k8s-bucket


ssh-keygen


kops create cluster architectso-k8s.k8s.local --zones us-east-1a --yes


kops validate cluster

kubectl get nodes


kops delete cluster architectso-k8s.k8s.local --yes

aws s3 rb s3://architectso-k8s-bucket --force


cat <<EOF | kubectl apply -f -

cat <<EOF | kubectl delete -f -

EOF



sudo scp -i /Users/serhii/.ssh/id_rsa \
  -rp /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-aws \
  serhii@192.168.1.108:~



HA

kops create cluster architectso-k8s.k8s.local \
      --zones us-east-1a, us-east-1b, us-east-1c \
      --node-count=3 \
      --master-zones us-east-1a, us-east-1b, us-east-1c \
      --yes



