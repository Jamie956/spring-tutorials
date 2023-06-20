

# org.springframework.beans.*



1.将BeanDefinition 注册到容器 Context

关键方法 registerBeanDefinition：容器 GenericApplicationContext 提供注册方法 registerBeanDefinition，把自定义 BeanDefinition 加入到 BeanFactory DefaultListableBeanFactory 的 beanDefinitionMap中。



如果注册的 BeanDefinition 是 FactoryBean，在 getBean 时会从 FactoryBean 查找 Bean



# org.springframework.context.*

1.容器加载 Bean

容器大类：

- AnnotationConfigApplicationContext：扫描解析标注解类和方法，创建管理 Bean
- ClassPathXmlApplicationContext：XML 定义 Bean



Bean 实例上是放在 DefaultListableBeanFactory，由容器使用