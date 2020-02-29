package com.amran.api.gateway;

import com.amran.api.gateway.security.AuthorizationHeaderFilter;
import com.amran.api.gateway.security.UserFeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RequestInterceptor getUserFeignClientInterceptor(OAuth2AuthorizedClientService clientService) {
		return new UserFeignClientInterceptor(clientService);
	}

	@Bean
	public AuthorizationHeaderFilter authHeaderFilter(OAuth2AuthorizedClientService clientService) {
		return new AuthorizationHeaderFilter(clientService);
	}

}
