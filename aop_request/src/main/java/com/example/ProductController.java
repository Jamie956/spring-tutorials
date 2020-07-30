package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    /**
     * localhost:8080/product/get
     *
     * {
     *     "id":"1",
     *     "name": "jamie",
     *     "price": 1
     * }
     * @param product
     * @return
     */
    @GetMapping("get")
    public String get(@RequestBody Product product) {
        System.out.println("product => " + product);
        return "ok";
    }
}
