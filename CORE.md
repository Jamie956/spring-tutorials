

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



# Spring AOP

Spring 整合 AspectJ 实现AOP 切面拦截编程



1.注解实现

@Aspect: 切面类

@Pointcut: 切点定义拦截的范围

@Around/@Before/@After: 拦截增强，就是拦截了做些什么

@EnableAspectJAutoProxy: 需要开启Spring 支持 AspectJ



# @Autowire

注解变量：变量装配从容器查找并注入

注解方法：方法参数从容器查找并注入



# @Bean

@Bean：注解方法，方法返回值对象由容器管理

@Bean(autowireCandidate = false)：Bean 不能注入到其他类，只能自己的类使用



# @Condition

判断是由加入容器



# @Import

类加入容器



# @Lazy

容器对象懒加载，只有使用的时候才去实例化



# @Lookup

注解方法，返回指定的容器实例，而不是方法的返回值



# @Primary

注解方法，有多个同类型Bean时，优先选择带有@Primary 注解的Bean



# @ComponentScan

扫描包下的Spring注解类

