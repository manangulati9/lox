#!/bin/bash

CMD="java -cp ./src/class: lox.Lox"

# Check arguments passed to `docker run`
if [ "$1" = "--file" ]; then
	if [ -z "$2" ]; then
		echo "Error: Missing script file path after --file argument."
		exit 1
	fi
	CMD="java -cp ./src/class: lox.Lox $2"
fi

exec $CMD
