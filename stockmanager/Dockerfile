#FROM java:openjdk-8u72-jre-alpine
FROM java:openjdk-8u72-jre

ADD ./target/stockmanager*.jar /app/stockmanager.jar

EXPOSE 8090:8090

CMD java -jar /app/stockmanager.jar

