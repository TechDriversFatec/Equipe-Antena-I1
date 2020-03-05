FROM openjdk:11
COPY build/libs/antenas-integracao.jar app.jar
CMD ["java", "-jar", "app.jar"]
