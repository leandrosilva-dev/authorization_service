FROM gradle:8.10.1-jdk21-alpine AS build

WORKDIR /app

COPY build.gradle settings.gradle /app/
COPY src /app/src

RUN gradle build --no-daemon

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar authorization_service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "authorization_service.jar"]
