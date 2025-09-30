FROM openjdk:21-jdk

WORKDIR /app

COPY target/SPE-MiniProject-1.0-SNAPSHOT.jar /app/SPE-MiniProject-Application.jar

CMD ["java", "-jar", "SPE-MiniProject-Application.jar"]