#!/bin/bash

javac -d src/class src/lox/*.java
java -cp src/class lox.Lox
