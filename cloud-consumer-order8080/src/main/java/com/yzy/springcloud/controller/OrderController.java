package com.yzy.springcloud.controller;

import com.yzy.springcloud.entity.WxProduct;
import com.yzy.springcloud.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate ;


    public   static  final  String paymenturl = "http://CLOUD-PAYMENT-SERVICE/cloud-payment-service";

    @PostMapping("/save")
    public R save(@RequestBody WxProduct wxProduct) {
        ResponseEntity<R> responseEntity = restTemplate.postForEntity(paymenturl+"/wxProduct/save", wxProduct, R.class);
        return responseEntity.getBody();
    }

    @GetMapping("/findByPage")
    public R findByPage() {
        ResponseEntity<R> responseEntity = restTemplate.getForEntity(paymenturl+"/wxProduct/findByPage", R.class);
        return responseEntity.getBody();
    }
}
