FROM openjdk:17
ADD target/firstSpringBootDemo-1.1-realese.jar firstSpringBootDemo-1.1-realese.jar
ENTRYPOINT [ "java", "-jar", "firstSpringBootDemo-1.1-realese.jar" ]
