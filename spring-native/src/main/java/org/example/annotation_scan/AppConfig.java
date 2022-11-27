package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * scan class of include custom define annotation
 */
@ComponentScan(value = "org.example.annotation_scan",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class)
)
public class AppConfig {
}
