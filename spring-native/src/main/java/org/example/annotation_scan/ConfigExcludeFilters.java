package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * once class annotated custom defined annotation, it will not be scan
 */
@ComponentScan(value = "org.example.annotation_scan",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class)
)
public class ConfigExcludeFilters {
}
