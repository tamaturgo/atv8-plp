FROM openjdk:13
COPY ./src /src
WORKDIR /src/
RUN javac App.java
CMD [ "java", "App" ]