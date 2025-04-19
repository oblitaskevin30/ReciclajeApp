# Etapa 1: Construcción
FROM eclipse-temurin:17 AS builder
WORKDIR /app
COPY . .

# Asegúrate de que mvnw tenga permisos de ejecución
RUN chmod +x ./mvnw

# Construye el proyecto
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]