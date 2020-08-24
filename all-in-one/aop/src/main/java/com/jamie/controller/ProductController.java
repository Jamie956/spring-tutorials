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
    public Product get(@RequestBody Product product) {
        return product;
    }
}
