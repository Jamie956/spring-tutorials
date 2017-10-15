package com.example.demo.rest;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "successed!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "successed!";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return "successed!";
    }

}
