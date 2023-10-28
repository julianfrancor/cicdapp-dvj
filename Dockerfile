# Usa la imagen base con Maven y Java 17
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Crea una imagen más pequeña con sólo el artefacto construido
FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY --from=build /app/target/cicdapp-dvj-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
