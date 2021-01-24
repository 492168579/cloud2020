package com.yzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZK8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZK8080.class, args);
    }
}
