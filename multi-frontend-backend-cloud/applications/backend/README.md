## Backend

There are Java and NodeJS in this side.


#### Technologies

Java, Spring, NodeJS, Express, Docker


#### Links

https://medium.com/javascript-in-plain-english/typescript-with-node-and-express-js-why-when-and-how-eb6bc73edd5d

https://github.com/microsoft/TypeScript-Node-Starter

https://www.typescriptlang.org/docs/handbook/module-resolution.html

https://github.com/Microsoft/TypeScript/issues/29272

https://nodejs.org/api/modules.html#modules_loading_from_the_global_folders

https://stackoverflow.com/questions/42964102/syntax-for-async-arrow-function


#### Commands

docker build -t nodejs-description .

docker run -p 4302:80 nodejs-description

docker run -d -p 4302:80 nodejs-description

docker container ls

docker build -t "nodejs-description:$(date -u +'%Y-%m-%dT%H-%M-%SZ')H$(git log -1 --pretty=%h)" .

docker container run -d -p 4302:80 nodejs-description:2019-07-19T18-22-11ZH7466043

docker image ls

docker container ls
