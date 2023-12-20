FROM amazoncorretto:21.0.1-al2023-headless
LABEL authors="dongzhang.li"
WORKDIR /root/startup/
COPY ./efc-member-app/efc-member-bootstrap/target/*.jar /root/startup
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bootstrap.jar"]