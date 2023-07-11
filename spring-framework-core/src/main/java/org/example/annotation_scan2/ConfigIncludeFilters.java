package org.example.annotation_scan2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * scan class of include custom define annotation
 */
@ComponentScan(value = "org.example.annotation_scan2",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class)
)
public class ConfigIncludeFilters {
}
