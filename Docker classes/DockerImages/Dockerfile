# FROM tomcat:9.0-jdk17-temurin
#
# COPY . /app
# WORKDIR /app
#
# RUN ./mvnw package -DskipTest
#
# RUN cp target/*.jar /usr/local/tomcat/webapps/ROOT.war
#
# CMD ["catalina.sh","run"]

FROM openjdk:23-slim
WORKDIR /app
COPY target/DockerImages-0.0.1-SNAPSHOT.jar .
EXPOSE 9099
ENTRYPOINT ["java","-jar","DockerImages-0.0.1-SNAPSHOT.jar"]