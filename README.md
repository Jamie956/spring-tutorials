# Overview

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



4.Database 查询用户密码

过滤器使用自定义 UserDetailsService

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



重写 UserDetailsService 方法 loadUserByUsername，查询数据库用户

```java
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 用户名查询数据库
        QueryWrapper<Users> qw = new QueryWrapper<>();
        qw.eq("username", username);
        Users users = userMapper.selectOne(qw);
        // 找不到用户认证失败
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return new User(users.getUsername(), encoder.encode(users.getPassword()),
                AuthorityUtils.commaSeparatedStringToAuthorityList("role"));
    }
}
```



# Spring security - login page



override configure and defined url

```java
    /*
    Spring 读取表单的 username/password: UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY

    访问 http://localhost:8080/hi 跳转到登录页面 http://localhost:8080/login.html
    不需要登录 http://localhost:8080/test/hi
    登录提交表单路径 http://localhost:8080/user/login
    登录成功跳转 http://localhost:8080/test/index
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登录页面
        http.formLogin()
                // 设置登录页面
                .loginPage("/login.html")
                // 登录访问路径
                .loginProcessingUrl("/user/login")
                // 登录成功跳转路径
                .defaultSuccessUrl("/test/index")
                // ?
                .permitAll()
                .and().authorizeRequests()
                // 设置可以直接访问的路径，不需要认证
                .antMatchers("/","/test/hi","/user/login").permitAll()
                .anyRequest().authenticated()
                // 关闭 csrf 保护
                .and().csrf().disable();
    }
```



Controller

```java
@RestController
public class Controller {
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/test/index")
    public String index() {
        return "index";
    }

    @GetMapping("/test/hi")
    public String testhi() {
        return "testhi";
    }
}
```



# spring security - authority

标记访问指定资源路径所需要的权限

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().and().authorizeRequests()
            .antMatchers("/test/index").hasAuthority("admins")
    .anyRequest().authenticated();
}
```

设置内存/数据库用户的权限

```java
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
    return new User("jamie", encoder.encode("123"), auths);
}
```









































