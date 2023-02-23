SET POLAR_GREETING="Hello fron ENV"
java -Dpolar.greeting="Hello from JVM" -Duser.country=US -Duser.language=en -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
