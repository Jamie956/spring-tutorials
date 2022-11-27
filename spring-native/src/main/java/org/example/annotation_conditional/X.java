package org.example.annotation_conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(MyCondition.class)
public class X {
    @Bean
    @Conditional(MyCondition.class)
    public Y y() {
        return new Y();
    }
}
