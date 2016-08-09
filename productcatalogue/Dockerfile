FROM java:openjdk-8-jdk
VOLUME /tmp
ADD target/product-1.0-SNAPSHOT.jar app.jar
ADD product-catalogue.yml app-config.yml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar", "server", "app-config.yml"]
