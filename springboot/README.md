# env
jdk 8
springboot 2.4.13

# first demo
https://docs.spring.io/spring-boot/docs/2.4.13/reference/html/getting-started.html#getting-started-first-application

# deploy springboot executable Jar
add plugin
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

mvn package

java -jar target/myproject-0.0.1-SNAPSHOT.jar


