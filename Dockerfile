#docker login -u "srinivaspalli" -p "Akki123$$" docker.io

#docker build -t srinivaspalli/restaurant-listing-service:latest .
#docker push srinivaspalli/restaurant-listing-service:latest
FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar