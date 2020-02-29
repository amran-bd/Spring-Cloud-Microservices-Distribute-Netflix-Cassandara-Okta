package com.amran.api.gateway.clientinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/ps/{productName}")
    @CrossOrigin
    String getProductName(@PathVariable("productName") String productName) ;
}
