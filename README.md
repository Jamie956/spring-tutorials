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

# spring security

## first demo

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

## filter
spring security 本质上是一个过滤链
- FilterSecurityInterceptor：方法级的权限过滤器，基本位于过滤链的最底部
- ExceptionTranslationFilter: 异常过滤器，处理认证授权中抛出的异常
- UsernamePasswordAuthenticationFilter: 对 login POST请求做拦截，校检表单中的用户名密码

查看全部过滤链
```text
FilterChainProxy#doFilterInternal
List<Filter> filters = getFilters(firewallRequest);
```

## interface
- UserDetailsService：查询数据库用户和密码的过程
- PasswordEncoder：数据加密接口，加密User密码



## set user

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



## login page



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



## authority

标记访问指定资源路径所需要的权限

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
  http.formLogin().and().authorizeRequests()
    // 将资源/test/index 标记为只有 admins 权限才能访问
    //                .antMatchers("/test/index").hasAuthority("admins")
    // 将资源/test/index 标记为只有 admins 或者manager 权限才能访问
    .antMatchers("/test/index").hasAnyAuthority("admins", "manager")
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



## role

资源标记角色

```java
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests()
                // 将资源/test/index 标记为只有 sale角色 才能访问
                .antMatchers("/test/index").hasRole("sale")
                // 只要用户角色是配置的其中一种角色就能访问
//                .antMatchers("/test/index").hasAnyRole("sale", "employee")
                .anyRequest().authenticated();
    }
```



设置用户角色

```java
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_sale");
        return new User("jamie", encoder.encode("123"), auths);
    }
}
```





## 403 page

```java
// 指定 403 跳转的页面
http.exceptionHandling().accessDeniedPage("/unauth.html");
```



## Annotation

1.Secured

```java
// 全局支持security 注解
@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```



```java
@RestController
public class Controller {
    @GetMapping("/hi")
    // 资源与角色绑定
    @Secured({"ROLE_sale"})
    public String hi() {
        return "hi";
    }
}
```



```java
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_sale");
    return new User("jamie", encoder.encode("123"), auths);
}
```



2.PreAuthorize



```java
// 全局支持security 注解
// prePostEnabled 开启支持注解 PreAuthorize
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```



```java
@GetMapping("/hi")
@PreAuthorize("hasAnyAuthority('admins')")
public String hi() {
    return "hi";
}
```



```java
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
    return new User("jamie", encoder.encode("123"), auths);
}
```



3.PostAuthorize

```java
@GetMapping("/hi")
// post 会执行方法体，即使没有权限
@PostAuthorize("hasAnyAuthority('admins')")
public String hi() {
    System.out.println("执行方法体");
    return "hi";
}
```



4.PostFilter



```java
@GetMapping("/hi1")
@PreAuthorize("hasAnyAuthority('admins')")
// only return filter result
@PostFilter("filterObject.username == 'a1'")
public List<User> hi1() {
    List<User> us = new ArrayList<>();
    List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
    us.add(new User("a1", "bb", auths));
    us.add(new User("b2", "bb", auths));
    return us;
}
```



5.PreFilter



## Logout

```java
http.logout().logoutUrl("/logout").logoutSuccessUrl("/index").permitAll();
```



## Remember me



security config

```java
// 注入数据源
@Autowired
private DataSource datasource;

//
@Bean
public PersistentRepository persistentRepository() {
  JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
  repo.setDataSource(dataSource);
  return repo;
}

// http config
config(http) {
  ...
    http.rememberMe().tokenRepository(persistentRepository())
    .tokenValiditySeconds(60)
    .userDetailsService(userDetailsService);
}
```



logout button

```html
<input type="checkbox" name="remember-me" title="rm" />
```



## CSRF

跨站请求伪造

一般是表单带token 区分是否伪造



















