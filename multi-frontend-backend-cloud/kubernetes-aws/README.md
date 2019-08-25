# Kubernetes with AWS


## Links

https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/connection-prereqs.html

https://docs.aws.amazon.com/elasticloadbalancing/latest/classic/elb-sticky-sessions.html

https://aws.amazon.com/emr/pricing/

https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html

https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/

https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/create-cluster-kubeadm/


https://stackoverflow.com/questions/55342907/kuberntes-ingress-aws-deployment-loadbalancer-pending

https://kubernetes.io/docs/reference/setup-tools/kubeadm/kubeadm-init/

https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/create-cluster-kubeadm/

https://kubernetes.io/docs/concepts/cluster-administration/cloud-providers/

https://blog.scottlowe.org/2019/02/18/kubernetes-kubeadm-and-the-aws-cloud-provider/

https://medium.com/jane-ai-engineering-blog/kubernetes-on-aws-6281e3a830fe

https://stackoverflow.com/questions/50668070/kube-controller-manager-doesnt-start-when-using-cloud-provider-aws-with-kubea


https://itnext.io/kubernetes-part-2-a-cluster-set-up-on-aws-with-aws-cloud-provider-and-aws-loadbalancer-f02c3509f2c2

https://github.com/heptio/aws-quickstart/blob/master/scripts/setup-k8s-master.sh.in


## Commands

sudo ssh -i /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/ec2.pem centos@

sudo su

yum -y update


kubeadm init


sudo scp -i /Users/serhii/Downloads/ec2.pem \
  -rp /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-aws \
  centos@ec2-52-71-253-111.compute-1.amazonaws.com:~


find . -name "*.yaml" -exec echo {} \;

find . -name "*.yaml" -exec kubectl apply -f {} \;


cat <<EOF | kubectl apply -f -

cat <<EOF | kubectl delete -f -

EOF

