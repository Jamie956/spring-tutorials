package org.example;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConvertTest2 {
    /**
     * convert request json to method param string
     *
     * test:
     *      method: post
     *      url: http://localhost:8080/convert1
     *      body: { "name": "aa", "age": 11}
     */
    @RequestMapping("/convert1")
    public String convert1(@RequestBody String body) {
        System.out.println("------->RequestBody: " + body);
        return "index";
    }

    /**
     * mapping RequestEntity to method param
     *
     * test:
     *      method: post
     *      url: http://localhost:8080/convert2
     *      body: { "name": "aa", "age": 11}
     */
    @RequestMapping("/convert2")
    public String convert2(RequestEntity<String> requestEntity) {
        System.out.println("------->requestHeader: "+requestEntity.getHeaders());
        System.out.println("------->requestBody: "+requestEntity.getBody());
        return "index";
    }

    /**
     * convert response from object to json
     * Add dependency jackson-databind parse object to json for response body
     *
     * test:
     *      method: get
     *      url: http://localhost:8080/convert3
     */
    @RequestMapping("/convert3")
    @ResponseBody
    public User convert3() {
        return new User("aa", "11", "aa");
    }

}
