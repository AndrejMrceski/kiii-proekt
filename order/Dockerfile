FROM maven:3.9.7-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY .mvn .
COPY mvnw .
COPY src ./src

RUN mvn clean install

FROM eclipse-temurin:17

RUN mkdir -p /home/admin/web

COPY --from=builder /app/target/order-0.0.1-SNAPSHOT.jar /home/admin/web/order.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/admin/web/order.jar"]