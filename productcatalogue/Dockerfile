FROM java:openjdk-8-jdk
VOLUME /tmp
ADD target/product-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
