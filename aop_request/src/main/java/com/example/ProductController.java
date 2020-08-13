package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("get")
    public Product get(@RequestBody Product product) {
        return product;
    }
}
