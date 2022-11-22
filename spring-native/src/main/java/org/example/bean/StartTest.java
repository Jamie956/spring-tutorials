package org.example.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

public class StartTest {
    @Test
    public void registerBeanDefinitionTest() {
        //create bean definition
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(X.class);

        //create container(new factory bean)
        GenericApplicationContext context = new GenericApplicationContext();
        String beanName = "randomName";
        //register bean definition custom define, actually put into bean definition map
        context.registerBeanDefinition(beanName, bd);
        //initial container bean
        context.refresh();

        //get from Cache of singleton objects
        System.out.println(context.getBean(X.class));
        System.out.println(context.getBean(beanName));
    }

    @Test
    public void registerFactoryBeanTest() {
        //create bean definition
        GenericBeanDefinition bd = new GenericBeanDefinition();
        //set bean class type, special type of factory bean
        bd.setBeanClass(MyFactoryBean.class);

		//new container (bean factory)
        GenericApplicationContext context = new GenericApplicationContext();
        String beanName = "randomName";
        //put into bean definition map
        context.registerBeanDefinition(beanName, bd);
        context.refresh();

		//return real bean factory when BeanFactory.FACTORY_BEAN_PREFIX &
        System.out.println(context.getBean("&" + beanName, MyFactoryBean.class));
        //doGetObjectFromFactoryBean: get bean from custom defined bean factory
        System.out.println(context.getBean(beanName, X.class));
    }

    @Test
    public void supplierBeanDefinitionTest() {
		GenericApplicationContext context = new GenericApplicationContext();
        Supplier<X> supplier = X::new;
        //instanceSupplier: set abstract bean definition property
        context.registerBean(X.class, supplier);
        //refresh() will do supplier get object and create bean instance and put into container
		//createBeanInstance
        context.refresh();

        System.out.println(context.getBean(X.class));
    }

    @Test
    public void updateBeanDefinitionTest() {
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(X.class);

		//get bean definition from factory bean from context, and update bean definition class name
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();

		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

		BeanDefinition bd = beanFactory.getBeanDefinition("org.example.bean.X");
		bd.setBeanClassName("org.example.bean.Z");

        context.refresh();

        System.out.println(context.getBean(Z.class));
    }

}
