package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class Application {
//    @Autowired
//    private static HaloService haloService;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

//        haloService.hi();
        // toto bean null
        HaloService bean = ctx.getBean(HaloService.class);
        System.out.println();
    }
}
