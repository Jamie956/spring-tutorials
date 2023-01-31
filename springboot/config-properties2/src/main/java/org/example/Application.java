package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

//ConfigurationProperties + EnableConfigurationProperties
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        Cat u1 = ctx.getBean(Cat.class);
        Assert.state("aa".equals(u1.getName()), "bean properties equal properties file config with prefix");
    }
}
