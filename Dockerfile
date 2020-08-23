FROM openjdk:14-alpine
COPY build/libs/seq-service-*-all.jar seq-service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "seq-service.jar"]