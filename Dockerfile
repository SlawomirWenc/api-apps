FROM openjdk:12-alpine
ADD target/api-apps-0.0.1-SNAPSHOT.jar .
EXPOSE 9090
CMD java -jar api-apps-0.0.1-SNAPSHOT.jar