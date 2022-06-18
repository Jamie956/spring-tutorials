package com.example;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/*
@ContextConfiguration
@TestPropertySource(properties = { "timezone = GMT", "port: 4242" })
class MyIntegrationTests {
    // class body...
}
 */
@ContextConfiguration
@TestPropertySource("/test.properties")
public class MyIntegrationTests {
    // class body...
}