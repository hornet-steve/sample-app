FROM java:8
ADD sample-app-1.0-SNAPSHOT.jar sample-app.jar
RUN bash -c 'touch /sample-app.jar'
ENTRYPOINT ["java", "-jar", "/sample-app.jar"]