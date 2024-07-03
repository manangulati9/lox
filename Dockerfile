FROM eclipse-temurin:21

WORKDIR /app

COPY . .

RUN javac -d ./src/class ./src/lox/*.java

COPY ./bin/entry.sh .

ENTRYPOINT [ "./entry.sh" ]
