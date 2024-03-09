# Sandwich Order Management

### Reference Documentation



### Guides

The following guides illustrate how to run the application:

* Pull Postgres Docker image: 
```
  $ docker pull postgres
```
* Run Postgres image:
```
$ docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=passwd -d postgres
```
* Access Postgres container:
```
$ docker exec -it postgres psql -U postgres
```
* Create the database:
```
$ create database sandwich
```
* Clone the repository:
```
$ git clone https://github.com/dazai/deepmatis.git
```
* Build using maven
```
$ ./mvnw package -DskipTests
```
* Build the application image:
```
$ docker build -t sandwich .
```
* Run the application:
```
$ docker run --name sandwich -p 8080:8080 -d sandwich
```
