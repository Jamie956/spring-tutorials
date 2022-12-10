package org.example.annotation_bean;

import junit.framework.TestCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration maked class using proxy
 */
@Configuration
public class AnnotationBeanWithConfig {
    public AnnotationBeanWithConfig() {
        // debug
        int i = 0;
    }

    @Bean
    public C c() {
        return new C();
    }

    @Bean
    public G g() {
        TestCase.assertSame(c(), c());
        return new G();
    }
}
