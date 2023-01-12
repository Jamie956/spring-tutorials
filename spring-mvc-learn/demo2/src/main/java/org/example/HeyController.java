package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HeyController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * test
     * http://localhost:8080/test1?name=11&address=123&id=12
     * method: get/post
     *
     * test
     * http://localhost:8080/test1?name=11&address=123&id=12
     * method: get/post
     */
    @RequestMapping(
            value = {"test1", "test2"},
            method = {RequestMethod.GET, RequestMethod.POST},
            //exist name, not exist password, address equal 123, id not equal 11
            params = {"name", "!password", "address=123", "id!=11"},
            //host equal localhost:8080
            headers = {"Host=localhost:8080"}
    )
    public String test() {
        return "index";
    }

    /**
     * ?: 任意单个字符
     * /a?a
     * http://localhost:8080/aaa -> ok
     * http://localhost:8080/a1a -> ok
     * http://localhost:8080/aa -> 404
     *
     * *: 任意0个或多个字符
     * /a*a
     *
     * **: 任意一层或多层目录
     * /**
     */
    @RequestMapping("/a?a")
    public String test2() {
        return "index";
    }

    /**
     * PathVariable convert path var
     * http://localhost:8080/user/11
     */
    @RequestMapping("/user/{id}")
    public String test3(@PathVariable("id") String id) {
        return "index";
    }

    /**
     * http://localhost:8080/test4?name=22
     * mapping http servlet request to method param
     */
    @RequestMapping("test4")
    public String test4(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "index";
    }

    /**
     * mapping param to method param
     * http://localhost:8080/test5?name=22&address=a&address=b
     */
    @RequestMapping("test5")
    public String test5(String name, String[] address) {
        return "index";
    }

    /**
     * mapping some of param to method param
     * http://localhost:8080/test6?na_me=22
     *
     * RequestParam:
     * name
     * value
     * required
     * defaultValue
     */
    @RequestMapping("test6")
    public String test6(@RequestParam("na_me") String name) {
        return "index";
    }

    /**
     * mapping request header to method param
     * http://localhost:8080/test6
     */
    @RequestMapping("/test7")
    public String test7(@RequestHeader("Host") String host) {
        return "index";
    }

    /**
     * mapping request cookies to method param
     */
    @RequestMapping("/test8")
    public String test8(@CookieValue("JESSIONID") String jessionid) {
        return "index";
    }

    /**
     * mapping request param to method param
     * http://localhost:8080/test9?name=22&address=a&address=b
     */
    @RequestMapping("/test9")
    public String test9(User user) {
        return "index";
    }
}
