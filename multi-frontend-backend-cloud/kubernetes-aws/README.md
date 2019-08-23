# Kubernetes with AWS


## Links

https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/connection-prereqs.html

https://docs.aws.amazon.com/elasticloadbalancing/latest/classic/elb-sticky-sessions.html

https://aws.amazon.com/emr/pricing/

https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html

https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/

https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/create-cluster-kubeadm/


## Commands

sudo su

yum -y update

cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
EOF

setenforce 0

sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config

yum install -y docker kubelet kubeadm kubectl --disableexcludes=kubernetes

systemctl enable --now kubelet

systemctl enable docker && systemctl start docker

systemctl enable kubelet && systemctl start kubelet

cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF

sysctl --system

swapoff -a &&  sed -i '/ swap / s/^/#/' /etc/fstab


kubeadm init


mkdir -p $HOME/.kube

sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config

sudo chown $(id -u):$(id -g) $HOME/.kube/config


kubeadm join 172.31.47.170:6443 --token 1301ud.z5h8trlnscwguh6c \
    --discovery-token-ca-cert-hash sha256:7be212c43a07e77ad8e2392b291af6bb63652e15878e28d132e4eaee1ada967d


kubectl get nodes

kubectl apply -f "https://cloud.weave.works/k8s/net?k8s-version=$(kubectl version | base64 | tr -d '\n')"


kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/static/mandatory.yaml

sudo scp -i /Users/serhii/Downloads/ec2.pem \
  -rp /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-aws \
  centos@ec2-52-71-253-111.compute-1.amazonaws.com:~


find . -name "*.yaml" -exec echo {} \;

find . -name "*.yaml" -exec kubectl apply -f {} \;

