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















# Bean Definition

1.将BeanDefinition 注册到容器 Context

关键方法 registerBeanDefinition：容器 GenericApplicationContext 提供注册方法 registerBeanDefinition，把自定义 BeanDefinition 加入到 BeanFactory DefaultListableBeanFactory 的 beanDefinitionMap中。



如果注册的 BeanDefinition 是 FactoryBean，在 getBean 时会从 FactoryBean 查找 Bean



# Context

1.容器加载 Bean

容器大类：

- AnnotationConfigApplicationContext：扫描解析标注解类和方法，创建管理 Bean
- ClassPathXmlApplicationContext：XML 定义 Bean



Bean 实例上是放在 DefaultListableBeanFactory，由容器使用








