package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//all method under this class able to parse return value as response body
@RestController
public class RestControllerTest {
    /**
     * RestController include ResponseBody to parse return value
     *
     * http request test:
     *      method: get
     *      url: http://localhost:8080/home/restc
     *
     */
    @RequestMapping("/restc")
    //@ResponseBody include ResponseBody
    public User restc() {
        return new User("aa", "11");
    }
}
