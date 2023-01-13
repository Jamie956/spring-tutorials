package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableConfigurationProperties(User.class)
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        User u = ctx.getBean(User.class);
        User u2 = ctx.getBean(User.class);
        System.out.println();
    }
}
