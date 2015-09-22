#!/bin/sh

export X_JAR=/Users/mathieu/.m2/repository/fr/mla/mower2/1.0-SNAPSHOT/mower2-1.0-SNAPSHOT.jar
export X_MAIN_CLASS=fr.mla.mower2.Application

export X_CONFIG_FILE=/Users/mathieu/Dvpt/workspace/Mower2/inErr.txt

${JAVA_HOME}/bin/java -cp ${X_JAR} ${X_MAIN_CLASS} ${X_CONFIG_FILE}
