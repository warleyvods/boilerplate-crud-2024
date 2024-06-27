FROM openjdk:21

EXPOSE 9000

WORKDIR /app

ENV DATABASE_CONNECTION_URL=""
ENV SCOPE="prod"


COPY /build/libs/project.jar /app/project.jar

CMD mkdir /app/files

ENTRYPOINT ["java", "-jar", "project.jar"]
