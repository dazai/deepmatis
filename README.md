# Sandwich Order Management

### Reference Documentation

The project is divided into these packages:
* Config: which contains different configuration classes for CORS, security, filters, etc ...
* Domain: package that contains the entities and the repositories they operate on.
* Dto: contains the request and response objects.
* Controllers: contains the controllers which are responsible for handling requests and responses.
* Services: package that encapsulates the business logic of the application.

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
### Add Hazelcast to project
Add the hazelcast dependency to the pom.xml file in the root of the project
```
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>hazelcast-spring</artifactId>
    <version>${hazelcast.version}</version>
</dependency>
```
Then configure it using hazelcast.yaml file in src/main/resources/ directory.
