FROM maven:3.9.6-eclipse-temurin-17 AS builder
#etap budowania:
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package


FROM eclipse-temurin:17-jre
#etap tworzenia obrazu (uzywam JRE, a nie JDK, bo JDK zawiera kompilator, co wazy wiecej
WORKDIR /app

#builder znaczy etap wyzej wspoimniany; wyciaga pliki .jar do nowego systemu (pod nazwa app.jar)
COPY --from=builder /build/target/*.jar app.jar

#tworzenie struktury folderow dla nastepnego COPY
RUN mkdir -p src/main/resources

# nadpisanie pliku appsettings.properties plikiem appsettings.docker.properties:
COPY src/main/resources/appsettings.docker.properties src/main/resources/appsettings.properties

#domyślny katalog na zamówienia wewnątrz kontenera
RUN mkdir /app/orders


#jest tu entrypoint, a nie cmd, a bo cmd dla parametrow jest przyznaczony, a entrypoint jest automatyczny
ENTRYPOINT ["java", "-jar", "app.jar"]