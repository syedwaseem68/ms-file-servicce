FROM amazoncorretto:11
VOLUME /tmp
COPY ./build/libs/ms-file--service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]