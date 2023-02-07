package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(HaloService.class)
@EnableConfigurationProperties(HaloProperties.class)
public class HaloServiceAutoConfiguration {
    @Bean
    public HaloService haloService() {
        return new HaloService();
    }
}
