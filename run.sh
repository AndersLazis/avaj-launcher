#!/bin/bash

PROJECT_DIR="$(pwd)"
SRC_DIR="$PROJECT_DIR/AvajLauncher/src"
OUT_DIR="$PROJECT_DIR/out"
SCENARIO_FILE="AvajLauncher/scenario.txt"


#Delete class files:
find . -name "*.class" -type f -delete

#Compile: 
find * -name "*.java" > sources.txt
javac -d "OUT_DIR" @sources.txt

java -cp "OUT_DIR" com.anderslazis.avaj.simulator.Simulator "$SCENARIO_FILE"