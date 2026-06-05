FROM eclipse-temurin:17

WORKDIR /app

RUN apt update && apt install -y maven

COPY pom.xml .

RUN mvn dependency:go-offline

CMD ["mvn", "spring-boot:run"]