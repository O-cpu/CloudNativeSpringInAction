SET POLAR_GREETING=Hello from ENV
SET SPRING_PROFILES_ACTIVE=testdata
SET user.language=en
SET user.country=US
REM SET SERVER_PORT=8081

java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
