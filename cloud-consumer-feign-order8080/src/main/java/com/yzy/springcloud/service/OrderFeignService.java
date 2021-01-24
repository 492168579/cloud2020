package com.yzy.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.yzy.springcloud.util.R;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {

	@GetMapping("cloud-payment-service/wxProduct/findByPage")
	public R findByPage();
	
	@GetMapping("cloud-payment-service/wxProduct/feign/timeout")
	public String paymentFeignTimeout();

}
