package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//加了 exclude componenet 注解的类不会被扫描，即使也加了 @Componentß
@ComponentScan(value = "org.example.annotation_scan",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class)
)
public class AppConfig2 {
}
