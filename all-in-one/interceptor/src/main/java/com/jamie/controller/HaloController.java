package com.jamie.controller;

import com.jamie.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/hi")
public class HaloController {

    @GetMapping("/hi")
    public String sayHi() {
        System.out.println("halo~");
        return "halo~";
    }

    /*
      localhost:8085/hi/get

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

    /*
    localhost:8085/hi/get?id=111
     */
    @GetMapping("/get/{id}")
    public void get(@PathVariable("id") String id) {
        System.out.println("get:" +id);
    }
}

