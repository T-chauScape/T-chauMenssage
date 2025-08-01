FROM node:20-alpine

RUN apk add --no-cache pkgconf

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000:3000

CMD ["npm", "run", "dev"]
