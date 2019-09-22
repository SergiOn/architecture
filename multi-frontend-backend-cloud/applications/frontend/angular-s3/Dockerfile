FROM node:10.16-alpine

ENV PORT 80

WORKDIR /usr/src/app

COPY ./dist/browser/index.html ./dist/browser/
COPY ./dist/browser/favicon.ico ./dist/browser/
COPY ./dist/server/* ./dist/server/
COPY ./dist/server.js ./dist/

EXPOSE $PORT

CMD ["node", "./dist/server.js"]
