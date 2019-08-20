# MetalLB


## Links

https://kubernetes.github.io/ingress-nginx/deploy/baremetal/

https://metallb.universe.tf/configuration/weave/

https://www.weave.works/docs/net/latest/kubernetes/kube-addon/#configuration-options

https://metallb.universe.tf/installation/

https://metallb.universe.tf/configuration/


## Commands

kubectl get nodes --selector=kubernetes.io/role!=master -o jsonpath={.items[*].status.addresses[?\(@.type==\"InternalIP\"\)].address}

kubectl apply -f "https://cloud.weave.works/k8s/net?k8s-version=$(kubectl version | base64 | tr -d '\n')&env.NO_MASQ_LOCAL=1"

kubectl apply -f https://raw.githubusercontent.com/google/metallb/v0.8.1/manifests/metallb.yaml

kubectl apply -f kubernetes-kubeadm/metallb/config-map.yaml

