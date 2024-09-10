FROM node:10

WORKDIR /user/src/app

#COPY package.json ./
COPY ./ ./

RUN npm install

CMD ["node", "server.js"]