#!/bin/sh

# propagates envs for using in Spring Boot configuration
export JAVA_OPTS="-DKAFKA_BOOTSTRAP_SERVERS=${KAFKA_BOOTSTRAP_SERVERS}"

java $JAVA_OPTS -Xmx1256m -Xss512k -XX:+UseSerialGC -jar /app/app.jar
