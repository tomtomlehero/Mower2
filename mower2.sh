#!/bin/sh

export X_JAR=/Users/mathieu/.m2/repository/fr/mla/mower2/1.0-SNAPSHOT/mower2-1.0-SNAPSHOT.jar
export X_MAIN_CLASS=fr.mla.mower2.Application

${JAVA_HOME}/bin/java -cp ${X_JAR} ${X_MAIN_CLASS}
