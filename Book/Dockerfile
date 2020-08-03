# For Java 8
FROM openjdk:8-jdk-alpine

#Changed the working directory to /opt/app
WORKDIR /opt/app

ARG JAR_FILE=target/Book-Form-0.0.1-SNAPSHOT.jar

# cp Book-Form-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} book-form.jar

# Run the jar file with ENTRYPOINT. java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","book-form.jar"]