FROM gradle:9.8.2-jdk25 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts ./
COPY --chown=gradle:gradle src ./src
RUN gradle --no-daemon test bootJar

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
USER 10001:10001
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
