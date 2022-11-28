package org.example.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class DebugUtils {
    public static void printBeanDefinition(GenericApplicationContext context, String step) {
        System.out.println("----------------- " + step + " list bean definition -----------------");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(name);
            System.out.println(beanDefinition);
        }
    }

    public static void printBeans(AbstractApplicationContext context, String info) {
        System.out.println("----------------- " + info + " start -----------------");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
            System.out.println(bean);
        }
        System.out.println("----------------- " + info + " end -----------------");
    }

}
