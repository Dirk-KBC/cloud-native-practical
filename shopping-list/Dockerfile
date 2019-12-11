FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ADD target/*.jar app.jar
COPY app.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY shopping-list shopping-list
#RUN cd shopping-list && ./mvnw package && cp target/shopping-list*.jar ../app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
