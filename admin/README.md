# What admin: Watch client health, GC, Memory, JVM ...

## admin server
dependency:
```
<dependency>
  <groupId>de.codecentric</groupId>
  <artifactId>spring-boot-admin-server</artifactId>
  <version>1.5.6</version>
</dependency>
<dependency>
  <groupId>de.codecentric</groupId>
  <artifactId>spring-boot-admin-server-ui</artifactId>
  <version>1.5.6</version>
</dependency>
```

## admin client
dependency:
```
<dependency>
  <groupId>de.codecentric</groupId>
  <artifactId>spring-boot-admin-starter-client</artifactId>
  <version>1.5.6</version>
</dependency>
```
properties:
```
spring.boot.admin.url=http://localhost:8084
spring.boot.admin.client.name=admin-client
```
