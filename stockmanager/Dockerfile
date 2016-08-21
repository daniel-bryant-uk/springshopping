FROM java:openjdk-8-jdk
VOLUME /tmp
ADD target/stockmanager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
