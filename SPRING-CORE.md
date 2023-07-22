# AspectJ

Spring 整合 AspectJ 实现 AOP 切面拦截编程



AOP的组成：

- 切面：包含切点和增强
- 切点：拦截对象的范围，定义哪些方法会被拦截
- 增强：拦截对象做的事情



Spring Aspect 注解实现：

- @Aspect: 定于切面类
- @Pointcut: 切点定义拦截的范围
- @Around/@Before/@After: 拦截增强，就是拦截了做些什么
- @EnableAspectJAutoProxy: 开启Spring 支持 AspectJ



CGLIB(Code Generation Library): 动态生成一个被代理类的子类，
子类重写被代理类的所有不是 final 修饰的方法，
并在子类中采用方法拦截的技术拦截父类所有的方法调用
在底层实现上，CGLIB 使用字节码处理框架 ASM，用于转换字节码并生成新的类



# @Async

@Async 注解方法，方法异步执行，而不是串行执行

注解 Async 的方法执行前被 gclib aop拦截，将方法提交到异步执行



需要开启异步任务：@EnableAsync



# @Autowire

注解变量：从容器查找变量对应的对象并注入

```java
@Autowired
private EmptyObject emptyObject;
```



注解方法：从容器查找方法参数对应的对象并注入

```java
@Autowired
public void setEmptyObject(EmptyObject emptyObject) {
    this.emptyObject = emptyObject;
}
```



注入方式

- byname：按 name 查找容器中的Bean
- bytype：按 type 查找容器中的Bean，比如容器中同时有两个同类型的实例，只是他们的 name 不一样，如果此时 bytype注入，就不知道要取哪一个实例



# @Bean

@Bean注解方法，被注解方法的返回值加入Spring容器

@Bean(autowireCandidate = false)：false 表示Bean 不能注入到其他类，只能自己的类使用



# @Conditional

是否加入Spring 容器的一个判断



# @Import

Import 注解值：

- 如果是普通类，加入容器 `@Import({EmptyObject.class})`
- 如果类是 ImportSelector，注入的是重写方法selectImports 返回值指向的对象
- 如果类是 ImportBeanDefinitionRegistrar，可以注册 Bean Definition



# @Lazy

Lazy 注解的类直到get使用时，才回去实例化，也就是在 Spring refresh 阶段不会被实例化



# @Lookup

`@Lookup("emptyObject")` 注解方法，注入方法的返回值，返回的是 Lookup指向的容器Bean，实际上是AOP实现



# @Primary

注解方法，在 get bean 有多个同类型Bean时，优先选择带有@Primary 注解的Bean



# @ComponentScan

`@ComponentScan(value = "org.example.annotation_scan1")` 扫描注解值包下的 Spring注解

可扫描自定义注解

```java
@ComponentScan(value = "org.example.annotation_scan2",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class)
)
```



# @Scope

定义 Spring Bean 是单例还是原型

原型：每次获取 Bean 都会创建一个新的 Bean



# @Value

Value 注解变量时，为变量赋值，值可以来源于配置文件、默认值、Hard code 字符串

一般用表达式获取值



# Spring AOP

编程式实现：

- 方式一：容器加入关键 Bean MethodInterceptor增强和 切点BeanNameAutoProxyCreator
- 方式二：容器加入 Bean DefaultPointcutAdvisor，可以同时配置切点和增强



XML声明式：Spring Bean 配置切点关键类 JdkRegexpMethodPointcut、增强关键类 DefaultPointcutAdvisor、切面关键类 ProxyFactoryBean



# Bean Definition

Bean Definition 是 Spring 对对象再进行多一层的定义和描述，从而有利于 Spring 管理容器的 Beans，比如控制容器实例的生命周期、实现依赖注入、扫描Spring Bean等等



将BeanDefinition 注册到容器，关键方法 GenericApplicationContext#registerBeanDefinition 把BeanDefinition 加入到 BeanFactory DefaultListableBeanFactory 的 beanDefinitionMap中



# Context



- AnnotationConfigApplicationContext：通过扫描注解类、方法和变量，管理容器Beans
- ClassPathXmlApplicationContext：通过XML 定义容器Beans



# Lifecycle

Spring 提供各种接口和注解给用户控制生命周期各个阶段的Beans：

- Bean实例化

- BeanNameAware：入参 Bean name，可修改
- BeanFactoryAware：入参 Bean Factory
- ApplicationContextAware：入参容器
- BeanPostProcessor：入参 Bean
- PostConstruct：无入参
- InitializingBean：无入参
- PreDestroy：无入参
- DisposableBean：无入参



# Listener

监听发布的事件：实现接口即可 `ApplicationListener<ApplicationEvent>`

发布事件：继承类 ApplicationEvent




