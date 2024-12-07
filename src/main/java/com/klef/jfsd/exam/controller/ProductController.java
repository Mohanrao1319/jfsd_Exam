package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        return Arrays.asList(products);
    }
}