package com.yzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignOrderHystrix8080 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderHystrix8080.class, args);
    }
}
