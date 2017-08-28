package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("01", "product01", "1.00"),
            new Product("02", "product02", "2.00"),
            new Product("03", "product03", "3.00")
    ));

    public List<Product> listProducts() {
        return products;
    }

    public Product getProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if(id.equals(products.get(i).getId())){
                return products.get(i);
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if(product.getId().equals(products.get(i).getId())){
                products.get(i).setName(product.getName());
                products.get(i).setPrice(product.getPrice());
            }
        }
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if(id.equals(products.get(i).getId())){
                products.remove(i);
            }
        }
    }

}
