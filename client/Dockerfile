#### Stage 1: Build the react application
FROM node:15.0.0-alpine as build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . ./
ARG REACT_APP_API_BASE_URL
ARG REACT_APP_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}
ENV REACT_APP_PUBLIC_URL=${REACT_APP_BASE_URL}
RUN npm run build

#### Stage 2: A minimal docker image with command to run the app
FROM nginx:1.19.3-alpine
COPY --from=build /app/build /var/www
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
ENTRYPOINT ["nginx","-g","daemon off;"]
