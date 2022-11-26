package org.example.autowired;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AnnotationAutowiredTest {

    @Test
    public void t1() {
        // AnnotatedBeanDefinitionReader
        // -> AnnotationConfigUtils.registerAnnotationConfigProcessors(..): register post processor bean definition
        // post processor bean definition class:
        //      ConfigurationClassPostProcessor.class
        //      AutowiredAnnotationBeanPostProcessor.class
        //      CommonAnnotationBeanPostProcessor.class
        //      EventListenerMethodProcessor.class
        //      DefaultEventListenerFactory.class
        // DefaultListableBeanFactory.registerBeanDefinition(..): register bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //register candidate beans
        printBeanDefinition(context, "before scan");
        context.scan("org.example.autowired");
        printBeanDefinition(context, "before refresh");
        //refresh -> invokeBeanFactoryPostProcessors -> put object annotated @Bean into bean definition names
        context.refresh();
        printBeanDefinition(context, "ending");

        TestCase.assertNotNull(context.getBean("x"));
        TestCase.assertNotNull(context.getBean("y"));
        TestCase.assertNotNull(context.getBean("z"));
        TestCase.assertNotNull(context.getBean("x1"));
        TestCase.assertNotNull(context.getBean("x2"));
        TestCase.assertNotSame(context.getBean("x"), context.getBean("x1"));
        TestCase.assertNotSame(context.getBean("x1"), context.getBean("x2"));
    }

    public static void printBeanDefinition(GenericApplicationContext context, String step) {
        System.out.println("----------------- " + step + " print bean definition -----------------");
        String[] beanDefinitionNames2 = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames2) {
            BeanDefinition beanDefinition = context.getBeanDefinition(name);
            System.out.println(beanDefinition);
        }
    }
}