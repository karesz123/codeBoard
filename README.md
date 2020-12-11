## Building a Full Stack Login application with technologies:
- Spring (Web, Boot, REST, JPA, Security, Validation)
- Lombok
- Nginx
- React
- JWT(JSON Web Token)
- PostgreSQL

The entire application is managed by Docker:
- The server folder:
  - contains the back-end side of the application
  - Dockerfile: build and run the front-end side of the application
- The client folder:
  - contains the front-end side of the application
  - Dockerfile: build and run the back-end side of the application
- Docker Compose for building and running the entire application, the multi-container application:
  -  docker-compose.yml file contains services for:
		-	front-end container
		-	back-end container
		-	postgreSQL container


## Steps to setup the Spring Boot React Login application

1. **Clone the application**

	```bash
	git clone https://github.com/karesz123/codeBoard.git
	cd codeBoard
	```

2. **Build and Run the application**

	You can build and run the entire application (Spring, Nginx, React, PostgreSQL) by typing the following command -

	```bash
	docker-compose up --build
	```
	
	The front-end server will start on port `3000`.
	The back-end server will be available on port `8080`.


