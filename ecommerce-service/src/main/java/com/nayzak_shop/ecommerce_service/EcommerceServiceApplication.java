package com.nayzak_shop.ecommerce_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceServiceApplication.class, args);
    }
}
