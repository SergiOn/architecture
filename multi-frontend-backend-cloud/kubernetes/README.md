# Kubernetes


## Links

https://www.jetbrains.com/help/idea/kubernetes.html

https://blog.jetbrains.com/idea/2018/03/intellij-idea-2018-1-kubernetes-support/

https://habr.com/ru/post/348688/

https://habr.com/ru/post/313644/

https://kubernetes.io/docs/reference/#api-reference

https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.15/

https://kubernetes.io/docs/concepts/workloads/controllers/deployment/

https://kubernetes.io/docs/concepts/configuration/overview/

https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/

https://kubernetes.io/docs/concepts/services-networking/ingress/

https://kubernetes.io/docs/concepts/services-networking/connect-applications-service/

https://kubernetes.io/docs/tasks/debug-application-cluster/get-shell-running-container/

https://stackoverflow.com/questions/51192713/how-to-make-curl-available-in-docker-image-based-java8-jdk-alpine-and-keep-the

https://stackoverflow.com/questions/35689628/starting-a-shell-in-the-docker-alpine-container

https://kubernetes.github.io/ingress-nginx/user-guide/ingress-path-matching/

https://github.com/kubernetes/ingress-nginx/blob/master/docs/user-guide/ingress-path-matching.md

https://github.com/kubernetes/ingress-nginx/blob/master/docs/examples/rewrite/README.md

https://kubernetes.github.io/ingress-nginx/user-guide/ingress-path-matching/

https://github.com/nginxinc/kubernetes-ingress/tree/master/examples/rewrites

https://devopscube.com/setup-ingress-kubernetes-nginx-controller/

https://medium.com/@cashisclay/kubernetes-ingress-82aa960f658e

https://stackoverflow.com/questions/26911213/find-files-and-execute-command/26911273

https://stackoverflow.com/questions/1341467/find-filenames-not-ending-in-specific-extensions-on-unix


## Issues

https://github.com/kubernetes/kubectl/issues/221


## Commands

### Minikube

minikube start

minikube addons enable ingress

kubectl get pods -n kube-system


kubectl apply -f angularjs-deployment.yaml

kubectl apply -f angularjs-service.yaml

kubectl apply -f angular-deployment.yaml

kubectl apply -f angular-service.yaml

kubectl get pod

kubectl get deployment

kubectl get service

kubectl describe svc/angularjs-service

kubectl describe svc/angular-service


type: ClusterIP

minikube service angular-service --url

minikube service angular-service

type: NodePort

kubectl apply -f angularjs-service.yaml --force


kubectl apply -f scala-translation-deployment.yaml

kubectl apply -f scala-translation-service.yaml

kubectl get svc

minikube service scala-translation-service


kubectl get pods

kubectl exec -it angular-deployment-558cbd7cb9-gx6m9 /bin/sh

curl http://scala-translation-service


kubectl apply -f nodejs-description-deployment.yaml

kubectl apply -f nodejs-description-service.yaml

kubectl apply -f java-family-deployment.yaml

kubectl apply -f java-family-service.yaml

kubectl apply -f java-greeting-deployment.yaml

kubectl apply -f java-greeting-service.yaml

kubectl apply -f java-greeting-service.yaml --force


kubectl apply -f ingress.yaml

kubectl get ingress


#### New version

kubectl rollout history deployment <name>

kubectl rollout undo deployment <name> --to-revision=<number>


kubectl rollout history deployment angularjs-deployment

kubectl rollout history deployment angular-deployment


cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/applications/frontend/angularjs

docker build -t "angularjs:$(date -u +'%Y-%m-%d')" .

docker tag angularjs:2019-08-11 serhiion/angularjs:2019-08-11

docker push serhiion/angularjs:2019-08-11


cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/applications/frontend/angular

docker build -t "angular:$(date -u +'%Y-%m-%d')" .

docker tag angular:2019-08-11 serhiion/angular:2019-08-11

docker push serhiion/angular:2019-08-11


cd /Users/serhii/Documents/Web/Training/Architecture/architecture/multi-frontend-backend-cloud/kubernetes/frontend

kubectl apply -f angularjs-deployment-new.yaml --record

kubectl apply -f angular-deployment-new.yaml --record


kubectl get pod

kubectl get deployment

kubectl get services

kubectl rollout history deployment angularjs-deployment

kubectl rollout history deployment angular-deployment
