FROM maven:3.6.3-jdk-11-slim AS builder

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-alpine-slim AS runner

EXPOSE 8080
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]