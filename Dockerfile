FROM java:8
EXPOSE 8080

USER 1001

VOLUME /tmp
RUN chgrp -R 0 /tmp && chmod -R g=u /tmp
ADD target/*.jar  /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","-Xms128m","-Xmx300m","/app.jar","--spring.profiles.active=prod"]
