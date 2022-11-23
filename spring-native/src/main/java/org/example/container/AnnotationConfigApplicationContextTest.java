package org.example.container;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {

    /**
     * new AnnotationConfigApplicationContext()
     * 1.AnnotationConfigApplicationContext -> GenericApplicationContext -> AbstractApplicationContext -> DefaultResourceLoader
     * @see org.springframework.context.support.GenericApplicationContext#GenericApplicationContext()
     * 2.initial processors
     * @see org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(BeanDefinitionRegistry, Object)
     * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#registerBeanDefinition
     *
     * context.scan()
     * 1.doScan step findCandidateComponents: scan path
     * 2.doScan step registerBeanDefinition: BeanDefinition put into BeanDefinitionMap
     * @see org.springframework.context.annotation.ClassPathBeanDefinitionScanner#doScan
     *
     * context.refresh()
     */
    @Test
    public void scanTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        //扫描包路径下的注解类, 将扫描的类 BeanDefinition 注册到 BeanDefinitionMap
        context.scan("org.example.container");
        System.out.println("-------------- before refresh --------------");

        context.refresh();
        System.out.println("-------------- after refresh --------------");

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        context.close();
    }

}
