FROM eclipse-temurin:21

WORKDIR /app

COPY . .

RUN javac -d ./src/class ./src/lox/*.java

COPY ./bin/entry.sh .

RUN chmod +x entry.sh

ENTRYPOINT [ "/app/entry.sh" ]
