FROM eclipse-temurin:21

WORKDIR /app

COPY . .

RUN javac -d ./src/class ./src/lox/*.java

ENTRYPOINT [ "./bin/entry.sh" ]
