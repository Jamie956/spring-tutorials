- aop: spring aspectj implement AOP
- async: spring schedule async task
- druid: sql admin platform
- eureka-demo: eureka, feign, hystrix...
- jackson: json convert
- jdbc-template: spring jdbc template
- jdbc-template-hikari: construct template by hikari
- jpa: spring jpa data access
- log
- micro-oauth2
- mq
- mybatis-annotation: ...
- mybatis-xml2: spring boot + mybatis xml
- properties
- remote-config
- remote-config-bug
- schedule
- springcloud2020
- spring-cloud-alibaba
- springdata
- spring-kafka
- spring-native: spring beans, spring context, annotation... spring framework how's work
- spring-security
- spring-security2
- spring-test-demo
- spring-web
- swagger
- thmeleaf
- updownload

# springboot spring security - first demo
add dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
```

test step
```text
start web application
request controller data: http://localhost:8080/hi
redirect to login page: http://localhost:8080/login
input login username and password:
username: user
password: print in console
request again: http://localhost:8080/hi
response message
```

# spring security - filter
spring security 本质上是一个过滤链
- FilterSecurityInterceptor：方法级的权限过滤器，基本位于过滤链的最底部
- ExceptionTranslationFilter: 异常过滤器，处理认证授权中抛出的异常
- UsernamePasswordAuthenticationFilter: 对 login POST请求做拦截，校检表单中的用户名密码

查看全部过滤链
```text
FilterChainProxy#doFilterInternal
List<Filter> filters = getFilters(firewallRequest);
```