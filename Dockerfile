FROM openjdk:17
COPY /target/blogapiservice-0.0.1-SNAPSHOT.jar blogapiservice-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "blogapiservice-0.0.1-SNAPSHOT.jar"]
