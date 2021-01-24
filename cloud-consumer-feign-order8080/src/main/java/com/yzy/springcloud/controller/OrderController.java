package com.yzy.springcloud.controller;

import com.yzy.springcloud.service.OrderFeignService;
import com.yzy.springcloud.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderFeignService orderFeignService;

	public static final String paymenturl = "http://CLOUD-PAYMENT-SERVICE/cloud-payment-service";



	@GetMapping("/findByPage")
	public R findByPage() {
		 return  orderFeignService.findByPage();
	}
	
	@GetMapping("/feign/timeout")
	public R timeout() {
		 return  R.ok().put("data", orderFeignService.paymentFeignTimeout());
	}
}
