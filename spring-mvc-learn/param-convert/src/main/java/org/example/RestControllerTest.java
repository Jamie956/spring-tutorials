package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//all method under this class able to parse return value as response body
@RestController
public class RestControllerTest {
    /**
     * RestController include ResponseBody able to convert return value
     *
     * test:
     *      method: get
     *      url: http://localhost:8080/restc
     *
     */
    @RequestMapping("/restc")
    //@ResponseBody include ResponseBody
    public User restc() {
        return new User("aa", "11", "aq");
    }
}

