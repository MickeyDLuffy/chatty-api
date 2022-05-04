FROM openjdk:17-oracle
EXPOSE 8081
ADD target/chatty-api.jar chatty-api.jar
ENTRYPOINT ["java", "jar", "/chatty-api.jar"]