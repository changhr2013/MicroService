FROM java:8
VOLUME /tmp
ADD microservice-discovery-eureka.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "-Dspring.profiles.active=peer1", "/app.jar"]