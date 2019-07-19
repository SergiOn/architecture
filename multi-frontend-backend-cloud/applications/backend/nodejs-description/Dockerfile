FROM node:10.16-alpine

ENV PORT 80
ENV NODE_PATH ./

WORKDIR /usr/src/app

COPY ./node_modules ./node_modules
COPY ./dist ./

EXPOSE $PORT

CMD ["node", "server.js"]
