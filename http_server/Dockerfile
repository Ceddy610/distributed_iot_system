#
# Build stage
#
FROM maven:3.8.5-openjdk-18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:18
COPY --from=build /home/app/target/http_server-jar-with-dependencies.jar /usr/local/lib/http_server.jar
EXPOSE 8051/tcp
ENTRYPOINT ["java","-jar","/usr/local/lib/http_server.jar"]