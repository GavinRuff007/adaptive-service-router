FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/rip-government-infrastructure-0.0.0-main-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]