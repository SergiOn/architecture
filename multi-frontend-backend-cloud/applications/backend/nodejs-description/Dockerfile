FROM node:10.16-alpine

ENV PORT 80
ENV NODE_PATH ./

WORKDIR /usr/src/app

COPY ./dist ./
COPY ./package.json ./package.json

RUN npm install --production

EXPOSE $PORT

CMD ["node", "server.js"]
