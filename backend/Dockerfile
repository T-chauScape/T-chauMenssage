FROM bitnami/java:24.0.1-11-debian-12-r5

WORKDIR /app

COPY . .

RUN ./mvnw package

EXPOSE 8080

CMD ["java", "-jar", "target/app.jar"]