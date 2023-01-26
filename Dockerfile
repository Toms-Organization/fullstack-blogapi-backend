FROM maven:3.8.1-openjdk-17-slim AS builder
WORKDIR /build
COPY pom.xml .
COPY src src/

# RUN mvn clean // To potentially emtpy a existing target folder
RUN mvn -f /build/pom.xml clean
# RUN mvn install -f /build/pom.xml
RUN mvn -f /build/pom.xml package


FROM openjdk:17
COPY --from=builder /build/target/blogapiservice-0.0.1-SNAPSHOT.jar ./
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "blogapiservice-0.0.1-SNAPSHOT.jar"]


# This works locally
#FROM openjdk:17
#COPY /target/blogapiservice-0.0.1-SNAPSHOT.jar blogapiservice-0.0.1-SNAPSHOT.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "blogapiservice-0.0.1-SNAPSHOT.jar"]
