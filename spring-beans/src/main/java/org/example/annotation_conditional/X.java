package org.example.annotation_conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(MyCondition.class)
public class X {
}
