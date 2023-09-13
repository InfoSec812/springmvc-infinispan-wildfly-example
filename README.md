# Spring MVC Example Application

## Overview

This is a simple example of a Spring Framework (not SpringBoot) application
which can be deployed on JBoss in a clustered configuration. The `web.xml`
has `<distributable />` added and a `jboss-all.xml` configuration which allows
the application to participate in EAP distributed session caching.

## Prerequisites

* OpenJDK >= 11.0.0 and < 15.0.0

## Running

1. Modify the `pom.xml` properties to point to one or more instances of EAP
    * `<jboss1.home>/path/to/first/jboss/server</jboss1.home>`
    * `<jboss2.home>/path/to/second/jboss/server</jboss2.home>`
2. Start the JBoss EAP instances: `./mvnw wildfly:start@jboss01 wildfly:start@jboss02`
3. Deploy the application: `./mvnw package wildfly:deploy@jboss01 wildfly:deploy@jboss02`

## Testing the distributed sessions:

```bash
export JSESSIONID=$(curl -v http://127.0.0.1:8080/springmvc-example-1.0-SNAPSHOT/sessiontest 2>&1 | grep JSESSIONID | awk '{print $3}')
curl -b "${JSESSIONID}" http://127.0.0.1:8080/springmvc-example-1.0-SNAPSHOT/sessiontest
curl -b "${JSESSIONID}" http://127.0.0.1:10080/springmvc-example-1.0-SNAPSHOT/sessiontest
## Alternate between the last two commands to show that data is being persisted across both JBoss instances

```