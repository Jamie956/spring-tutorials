package org.example.annotation_conditional;

import org.springframework.context.annotation.Conditional;

@Conditional(MyCondition.class)
public class X {

}
