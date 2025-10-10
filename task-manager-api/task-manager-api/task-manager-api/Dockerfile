# Etapa 1: Build con Gradle 8.14.3 y JDK 21 (compilación)
FROM gradle:8.14.3-jdk21 AS build
COPY --chwon=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon

# Etapa 2: Runtime con JDK 21 (ejecución)
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar task_manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "task_manager.jar"]