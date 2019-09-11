FROM node:10.16-alpine

ENV PORT 80

WORKDIR /usr/src/app

COPY ./dist ./dist

EXPOSE $PORT

CMD ["node", "./dist/server.js"]
