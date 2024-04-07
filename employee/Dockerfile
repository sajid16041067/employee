FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY target/employee-0.0.1-SNAPSHOT.jar /app
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app/employee-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]