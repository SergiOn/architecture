# Kubernetes with Kubeadmin


## DNS

| IP               | Host         |
|------------------|--------------|
| 192.168.31.6     | master.k8s   |
| 192.168.31.93    | node1.k8s    |
| 192.168.31.91    | node2.k8s    |


## Init

Your Kubernetes control-plane has initialized successfully!

To start using your cluster, you need to run the following as a regular user:

  mkdir -p $HOME/.kube
  sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
  sudo chown $(id -u):$(id -g) $HOME/.kube/config

You should now deploy a pod network to the cluster.
Run "kubectl apply -f [podnetwork].yaml" with one of the options listed at:
  https://kubernetes.io/docs/concepts/cluster-administration/addons/

Then you can join any number of worker nodes by running the following on each as root:

kubeadm join 192.168.31.6:6443 --token v6ztvl.ui3fne9v918c4r25 \
    --discovery-token-ca-cert-hash sha256:ad7474f239593f2d136a6858d3c64289167d3eb420409350915ae78d89240cc8 


## Links

https://serverfault.com/questions/264595/can-scp-copy-directories-recursively

https://appscode.com/products/voyager/8.0.1/guides/ingress/tls/overview/

https://carlos.mendible.com/2018/03/20/secure-your-kubernetes-services-with-nginx-ingress-controller-tls-and-more/

https://stackoverflow.com/questions/26911213/find-files-and-execute-command/26911273

https://kubernetes.io/docs/concepts/services-networking/ingress/

https://www.base64encode.org/


## Commands

find -name '*.yaml' -exec kubectl apply -f {} \;

