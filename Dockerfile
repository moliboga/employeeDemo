FROM openjdk:18
WORKDIR /tmp/server
COPY ./target/employee-0.0.1-SNAPSHOT.jar employee.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "employee.jar"]