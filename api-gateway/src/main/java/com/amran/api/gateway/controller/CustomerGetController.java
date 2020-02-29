package com.amran.api.gateway.controller;

import com.amran.api.gateway.clientinterface.CustomerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerGetController {

    private final CustomerClient customerClient;

    public CustomerGetController(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    private String fallback() {
        return "Hello! This is Fallback.";
    }

    @GetMapping("/customer")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public String goodCars() {
        return customerClient.getCustomerMsg();
    }

}
