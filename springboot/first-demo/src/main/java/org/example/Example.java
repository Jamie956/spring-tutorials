package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @EnableAutoConfiguration
 *      @AutoConfigurationPackage -> @Import(AutoConfigurationPackages.Registrar.class) -> AutoConfigurationPackages.Registrar: register package location as bean definition
 *      @Import(AutoConfigurationImportSelector.class) -> group selector -> selectImports -> import spring boot XXXAutoConfiguration beans
 */
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //debug
        //1.construct SpringApplication
        //1.1 confirm which webApplicationType
        //1.2 load Factories
        //      spring-boot-2.4.13.jar!/META-INF/spring.factories
        //      spring-boot-autoconfigure-2.4.13.jar!/META-INF/spring.factories
        //      spring-beans-5.3.13.jar!/META-INF/spring.factories
        //1.3 Instance beans
        //      ApplicationContextInitializer
        //      ApplicationListener
        //2.SpringApplication run
        //todo
        SpringApplication.run(Example.class, args);
    }

}