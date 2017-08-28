package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4 0004.
 */

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/listProducts")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @RequestMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addProduct")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "successed!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateProduct/{id}")
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "successed!";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return "successed!";
    }

}
