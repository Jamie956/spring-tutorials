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
    public List<Product> list(){
        return productService.listProducts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public Product get(@PathVariable String id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void add(@RequestBody Product product){
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void remove(@PathVariable String id){
        productService.deleteProduct(id);
    }

}
