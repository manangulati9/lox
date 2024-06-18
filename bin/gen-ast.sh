#!/bin/bash

cd ../src/ || exit 1
javac tools/GenerateAst.java
java tools.GenerateAst lox
