package org.example.bean_definition;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

public class Main {
    @Test
    public void registerBeanDefinitionTest() {
        //create container(new factory bean)
        GenericApplicationContext context = new GenericApplicationContext();
        String beanName = "myBean";
        //create bean definition
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(EmptyObject.class);
        //register bean definition custom define, actually put into bean definition map
        context.registerBeanDefinition(beanName, beanDefinition);
        //initial container bean
        context.refresh();

        //get bean from Cache of singleton objects
        Assert.assertNotNull(context.getBean(EmptyObject.class));
        Assert.assertNotNull(context.getBean(beanName));
    }

    @Test
    public void registerFactoryBeanTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        String beanName = "myBean";
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        //set bean class type, special type of factory bean
        beanDefinition.setBeanClass(MyFactoryBean.class);
        context.registerBeanDefinition(beanName, beanDefinition);
        context.refresh();

		//get real bean factory with &
        MyFactoryBean factoryBean = context.getBean(BeanFactory.FACTORY_BEAN_PREFIX + beanName, MyFactoryBean.class);
        Assert.assertNotNull(factoryBean);
        //debug FactoryBeanRegistrySupport.doGetObjectFromFactoryBean: get bean from custom defined bean factory
        EmptyObject xBean = context.getBean(beanName, EmptyObject.class);
        Assert.assertNotNull(xBean);
    }

    @Test
    public void supplierBeanDefinitionTest() {
		GenericApplicationContext context = new GenericApplicationContext();
        Supplier<EmptyObject> supplier = () -> {
            // break point here
            return new EmptyObject();
        };
        //instanceSupplier: set abstract bean definition property
        context.registerBean(EmptyObject.class, supplier);
        //refresh() will do supplier get object and create bean instance and put into container
        context.refresh();

        Assert.assertNotNull(context.getBean(EmptyObject.class));
    }

}
