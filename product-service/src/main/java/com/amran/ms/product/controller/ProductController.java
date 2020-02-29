package com.amran.ms.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/ps/{productName}")
    public String getHelloWorld(@PathVariable String productName) {
        return "Hi " + productName +" response from Product Service API.";
    }
}
