## Frontend

There are AngularJS and Angular in this side.
The Angular has basic and server side rendering.


#### Technologies

AngularJS, Angular, Angular Universal, Webpack, Nginx, Docker


#### Links

https://github.com/angular-ui/ui-router/wiki/Quick-Reference#stateconfig

https://github.com/angular-ui/ui-router/wiki/Frequently-Asked-Questions#how-to-configure-your-server-to-work-with-html5mode

https://hub.docker.com/_/nginx

https://stackoverflow.com/questions/6312872/how-can-i-get-the-current-date-in-yyyy-mm-dd-format-in-os-x-bash

https://angular.io/cli/new

https://angular.io/guide/universal

https://blog.angular-university.io/angular-universal/

https://github.com/angular/universal

https://github.com/angular/universal-starter

https://medium.com/@MarkPieszak/angular-universal-server-side-rendering-deep-dive-dc442a6be7b7


#### Commands

docker exec -it <container> /bin/sh

docker build -t "angularjs:$(date -u +'%Y-%m-%dT%H-%M-%SZ')H$(git log -1 --pretty=%h)" .

docker image ls

docker run -d -p 4100:80 angularjs:2019-07-12T22-56-17Z
docker run -d -p 4100:80 angularjs:2019-07-13T10-51-15ZH6e8414d
docker run -d -p 4100:80 639a63acb356

docker container ls
docker container ls -a
docker container kill/stop <container>
docker container rm <container>


ng add @nguniversal/express-engine --clientProject angular
npm run build:ssr && npm run serve:ssr
