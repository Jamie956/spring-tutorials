package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
// create B when exist bean name a
@ConditionalOnBean(name = "a")
// create B when not exist bean name a1
@ConditionalOnMissingBean(name = "a1")
public class B {
}
