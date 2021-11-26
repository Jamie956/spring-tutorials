package com.jamie.controller;

import com.jamie.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    /*
      url: localhost:8085/product/get

      body:
      {
          "id":"1",
          "name": "jamie",
          "price": 1
      }
     */
    @GetMapping("/get")
    public Product getMethod(@RequestBody Product product) {
        return product;
    }


    @GetMapping("/get1")
    public Product getMethod1(@RequestBody Product product) {
        return product;
    }


    @GetMapping("/get2")
    public Product getMethod2(@RequestBody Product product) {
        return product;
    }

    @GetMapping("/get3")
    public Product getMethod3(@RequestBody Product product) {
        return product;
    }

    @GetMapping("/set")
    public Product setMethod(@RequestBody Product product) {
        return product;
    }
}
