FROM openjdk:17
EXPOSE 8080
ADD target/sandwich.jar sandwich.jar
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "sandwich.jar"]