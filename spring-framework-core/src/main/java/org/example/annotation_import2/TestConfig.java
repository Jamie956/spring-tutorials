package org.example.annotation_import2;

import org.example.share.EmptyObject;
import org.springframework.context.annotation.Bean;

public class TestConfig {
    @Bean
    public EmptyObject getObject(){
        return new EmptyObject();
    }
}
