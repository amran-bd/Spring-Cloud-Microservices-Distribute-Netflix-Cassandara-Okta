package com.amran.ms.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/customer")
    public String getHelloWorld() {
        return "Hi response from Customer Service API.";
    }
}
