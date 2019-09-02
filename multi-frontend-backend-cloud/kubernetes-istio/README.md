# Kubernetes with Istio


## Links

https://istio.io/docs/concepts/traffic-management/#match-request-uri

https://istio.io/docs/reference/config/networking/v1alpha3/destination-rule/

https://medium.com/containerum/managing-service-mesh-on-kubernetes-with-istio-60ee5e8c5efe

https://stackoverflow.com/questions/53208081/istio-session-affinity-with-weighted-load-balancer

https://github.com/wg/wrk

https://dev.to/peterj/what-are-sticky-sessions-and-how-to-configure-them-with-istio-1e1a

https://docs.flagger.app/how-it-works

https://github.com/weaveworks/flagger


## Commands

minikube start --cpus=4 --memory='14gb'

cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-istio/install/kubernetes/helm/istio-init/files

for i in ./crd*yaml; do kubectl apply -f $i; done

cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes-istio/install/kubernetes

kubectl apply -f istio-demo.yaml

kubectl get svc -n istio-system

kubectl get pods -n istio-system

kubectl get ns default -o yaml

kubectl label namespace default istio-injection=enabled

kubectl get ns default -o yaml

