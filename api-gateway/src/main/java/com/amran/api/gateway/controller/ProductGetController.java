package com.amran.api.gateway.controller;

import com.amran.api.gateway.clientinterface.CustomerClient;
import com.amran.api.gateway.clientinterface.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductGetController {

    private final ProductClient productClient;

    public ProductGetController(ProductClient productClient) {
        this.productClient = productClient;
    }

    private String fallback() {
        return "Hello! This is Fallback Product.";
    }

    @GetMapping("/ps/{productName}")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public String getProduct() {
        return productClient.getProductName("productName");
    }
}
