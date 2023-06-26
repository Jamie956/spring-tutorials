package org.example.annotation_import2;

import org.example.share.EmptyObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public EmptyObject getObject(){
        return new EmptyObject();
    }
}
