package org.example.annotation_importing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Import({X.class})
 * 1.
 * AbstractApplicationContext#refresh step invokeBeanFactoryPostProcessors
 * -> ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 第一次 invokeBeanDefinitionRegistryPostProcessors 调 ConfigurationClassPostProcessor
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 2.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step parser.parse
 * -> ConfigurationClassParser#processImports step processConfigurationClass
 * 将 import class X 存到 configurationClasses
 * @see org.springframework.context.annotation.ConfigurationClassParser#processImports
 * 3.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step this.reader.loadBeanDefinitions
 * -> registerBeanDefinitionForImportedConfigurationClass step this.registry.registerBeanDefinition
 * 从 configurationClasses 获取注解的class，加入 BeanDefinitionMap
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#registerBeanDefinitionForImportedConfigurationClass
 * 4.
 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
 * 实例化 BeanDefinitionMap 的bean
 *
 * Import({TestConfig.class})
 * 1.
 * AbstractApplicationContext#refresh step invokeBeanFactoryPostProcessors
 * -> ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 第一次 invokeBeanDefinitionRegistryPostProcessors 调 ConfigurationClassPostProcessor
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 2.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step parser.parse
 * -> ConfigurationClassParser#processImports step processConfigurationClass
 * 将 import class TestConfig 存到 configurationClasses，而 Y 还没存
 * @see org.springframework.context.annotation.ConfigurationClassParser#processImports
 * 3.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step this.reader.loadBeanDefinitions
 * -> ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsForConfigurationClass step registerBeanDefinitionForImportedConfigurationClass
 * -> registerBeanDefinitionForImportedConfigurationClass step this.registry.registerBeanDefinition
 * 从 configurationClasses 获取注解的class，加入 BeanDefinitionMap
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsForConfigurationClass
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#registerBeanDefinitionForImportedConfigurationClass
 * 4.
 * loadBeanDefinitionsForConfigurationClass step loadBeanDefinitionsForBeanMethod
 * 在TestConfig加入BeanDefinition Map后，紧接着 TestConfig 类的注解@Bean Y 加到 BeanDefinitionMap
 * 5.
 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
 * 实例化 BeanDefinitionMap 的bean
 *
 * Import({TestImportSelector.class})
 * 1.
 * AbstractApplicationContext#refresh step invokeBeanFactoryPostProcessors
 * -> ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 第一次 invokeBeanDefinitionRegistryPostProcessors 调 ConfigurationClassPostProcessor
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 2.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step parser.parse
 * -> ConfigurationClassParser#processConfigurationClass step doProcessConfigurationClass
 * 入口
 * -> ConfigurationClassParser#processImports step BeanUtils.instantiateClass(candidateClass, ImportSelector.class)
 * 反射实例化 ImportSelector
 * -> ConfigurationClassParser#processImports step selector.selectImports
 * 调 ImportSelector 实现类重写的方法 selectImports，自定义selectImports返回路径将加入 BeanDefinitionMap
 * @see org.springframework.context.annotation.ConfigurationClassParser#processConfigurationClass
 * @see org.springframework.context.annotation.ConfigurationClassParser#processImports
 * 3.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step parser.parse
 * -> ConfigurationClassParser#processConfigurationClass step this.configurationClasses.put
 * 将 import class 和 @Configuration注解类 存到 configurationClasses，每次存一个
 * 4.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step this.reader.loadBeanDefinitions
 * -> registerBeanDefinitionForImportedConfigurationClass step this.registry.registerBeanDefinition
 * 从 configurationClasses 获取注解的class，加入 BeanDefinitionMap
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#registerBeanDefinitionForImportedConfigurationClass
 * 5.
 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
 * 实例化 BeanDefinitionMap 的bean
 *
 * Import({TestImportBeanDefinitionRegistrar.class})
 * 1.
 * AbstractApplicationContext#refresh step invokeBeanFactoryPostProcessors
 * -> ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 第一次 invokeBeanDefinitionRegistryPostProcessors 调 ConfigurationClassPostProcessor
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * 2.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step parser.parse
 * -> ConfigurationClassParser#processImports step BeanUtils.instantiateClass(candidateClass, ImportBeanDefinitionRegistrar.class)
 * 反射实例化 自定义 TestImportBeanDefinitionRegistrar
 * -> ConfigurationClassParser#processImports step configClass.addImportBeanDefinitionRegistrar
 * 自定义 ImportBeanDefinitionRegistrar 添加到 ConfigurationClass.importBeanDefinitionRegistrars
 * @see org.springframework.context.annotation.ConfigurationClass.importBeanDefinitionRegistrars
 * 3.
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions step this.reader.loadBeanDefinitions
 * -> ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsFromRegistrars
 * 从 importBeanDefinitionRegistrars 获取的实例 调 ImportBeanDefinitionRegistrar#registerBeanDefinitions
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsFromRegistrars
 * 4.
 * TestImportBeanDefinitionRegistrar#registerBeanDefinitions
 * 自定义 import的实现方法 registerBeanDefinitions 将 bean 加入 BeanDefinitionMap
 * 5.
 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
 * 实例化 BeanDefinitionMap 的bean
 */
//@Import({X.class})
//@Import({TestConfig.class})
//@Import({TestImportSelector.class})
//@Import({TestImportBeanDefinitionRegistrar.class})
@Import({X.class, TestConfig.class, TestImportSelector.class, TestImportBeanDefinitionRegistrar.class})
@Configuration
public class AppConfig {
}