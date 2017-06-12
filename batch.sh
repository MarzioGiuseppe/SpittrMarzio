#!/bin/bash
# My first script

echo "Esecuzione automatica build gradle , conversione maven e copia pom.xml"
gradle clean & gradle install & cp build/poms/pom-default.xml pom.xml