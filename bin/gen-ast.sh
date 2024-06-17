#!/bin/bash

cd ../src/ || return
javac tools/GenerateAst.java
java tools.GenerateAst lox
