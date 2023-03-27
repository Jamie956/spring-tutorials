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

# spring security - first demo
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

# spring security - interface
- UserDetailsService：查询数据库用户和密码的过程
- PasswordEncoder：数据加密接口，加密User密码



# spring security - set user

1.配置文件设置 user

```
spring.security.user.name=
spring.security.user.password=
```



获取输入的登录用户和密码：UsernamePasswordAuthenticationFilter#attemptAuthentication



2.重写类设置 user

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().withUser("jamie")
                .password(passwordEncoder.encode("123"))
                .roles("admin");
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
```



- debug SecurityConfig#configure, on application startup, init username/password by ProviderManage
- user inputting username&password and obtain by UsernamePasswordAuthenticationFilter#attemptAuthentication
- auth get user from memory map by ProviderManage.authenticate -> InMemoryUserDetailsManager#loadUserByUsername



3.自定义实现类设置 user

配置使用 UserDetailsService 提供 username&password

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```



重写 loadUserByUsername，设置 username&password

```java
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User("jamie", encoder.encode("123"), auths);
    }
}
```





