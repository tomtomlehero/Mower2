#!/bin/sh

export X_JAR=/Users/mathieu/.m2/repository/fr/mla/mower2/1.0-SNAPSHOT/mower2-1.0-SNAPSHOT.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot-starter-web/1.2.5.RELEASE/spring-boot-starter-web-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot-starter/1.2.5.RELEASE/spring-boot-starter-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot/1.2.5.RELEASE/spring-boot-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.2.5.RELEASE/spring-boot-autoconfigure-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.2.5.RELEASE/spring-boot-starter-logging-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.12/jcl-over-slf4j-1.7.12.jar:/Users/mathieu/.m2/repository/org/slf4j/slf4j-api/1.7.12/slf4j-api-1.7.12.jar:/Users/mathieu/.m2/repository/org/slf4j/jul-to-slf4j/1.7.12/jul-to-slf4j-1.7.12.jar:/Users/mathieu/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.12/log4j-over-slf4j-1.7.12.jar:/Users/mathieu/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar:/Users/mathieu/.m2/repository/ch/qos/logback/logback-core/1.1.3/logback-core-1.1.3.jar:/Users/mathieu/.m2/repository/org/yaml/snakeyaml/1.14/snakeyaml-1.14.jar:/Users/mathieu/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/1.2.5.RELEASE/spring-boot-starter-tomcat-1.2.5.RELEASE.jar:/Users/mathieu/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/8.0.23/tomcat-embed-core-8.0.23.jar:/Users/mathieu/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/8.0.23/tomcat-embed-el-8.0.23.jar:/Users/mathieu/.m2/repository/org/apache/tomcat/embed/tomcat-embed-logging-juli/8.0.23/tomcat-embed-logging-juli-8.0.23.jar:/Users/mathieu/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/8.0.23/tomcat-embed-websocket-8.0.23.jar:/Users/mathieu/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.4.6/jackson-databind-2.4.6.jar:/Users/mathieu/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.4.6/jackson-annotations-2.4.6.jar:/Users/mathieu/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.4.6/jackson-core-2.4.6.jar:/Users/mathieu/.m2/repository/org/hibernate/hibernate-validator/5.1.3.Final/hibernate-validator-5.1.3.Final.jar:/Users/mathieu/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/Users/mathieu/.m2/repository/org/jboss/logging/jboss-logging/3.1.3.GA/jboss-logging-3.1.3.GA.jar:/Users/mathieu/.m2/repository/com/fasterxml/classmate/1.0.0/classmate-1.0.0.jar:/Users/mathieu/.m2/repository/org/springframework/spring-core/4.1.7.RELEASE/spring-core-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/spring-web/4.1.7.RELEASE/spring-web-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/spring-aop/4.1.7.RELEASE/spring-aop-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/Users/mathieu/.m2/repository/org/springframework/spring-beans/4.1.7.RELEASE/spring-beans-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/spring-context/4.1.7.RELEASE/spring-context-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/spring-webmvc/4.1.7.RELEASE/spring-webmvc-4.1.7.RELEASE.jar:/Users/mathieu/.m2/repository/org/springframework/spring-expression/4.1.7.RELEASE/spring-expression-4.1.7.RELEASE.jar
export X_MAIN_CLASS=fr.mla.mower2.MowerApp

export X_CONFIG_FILE=/Users/mathieu/Dvpt/workspace/Mower2/in.txt

${JAVA_HOME}/bin/java -cp ${X_JAR} ${X_MAIN_CLASS} ${X_CONFIG_FILE}
