#!/bin/bash

# Comprimir amb: folder=`basename "$PWD"` && zip -r ../$folder.zip . -x '**/.*' -x '**/__MACOSX' -x '*.zip'

reset
rm -f ./bin/*.* 
mkdir -p ./bin
cp -r ./assets ./bin

if [[ $OSTYPE == 'linux-gnu' ]]; then
    javac -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" -d ./bin/ ./src/*.java
    java  -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" Main
fi

if [[ $OSTYPE == 'darwin'* ]] && [[ $(arch) == 'i386' ]]; then
    javac -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" -d ./bin/ ./src/*.java
    java  -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" Main
fi

if [[ $OSTYPE == 'darwin'* ]] && [[ $(arch) == 'arm64' ]]; then
    javac -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" -d ./bin/ ./src/*.java
    java  -cp "./:./bin/:./lib/password4j-1.6.2.jar:./lib/slf4j-simple-1.6.1.jar:./lib/slf4j.api-1.6.1.jar" Main
fi