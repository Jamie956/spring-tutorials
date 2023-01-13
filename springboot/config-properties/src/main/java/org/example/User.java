package org.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component + @ConfigurationProperties
//or @ConfigurationProperties + @EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "test.example")
@Configuration(proxyBeanMethods = true)
public class User {
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
