package com.amran.api.gateway.clientinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("customer-service")
public interface CustomerClient {

    @GetMapping("/customer")
    @CrossOrigin
    String getCustomerMsg();
}
