package com.yzy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yzy.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/consumer")
@Slf4j
@Controller
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
})
public class OrderController {

	@Autowired
	private OrderFeignService orderFeignService;

	@GetMapping("/hystrix/ok/{id}")
	@ResponseBody
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = orderFeignService.paymentInfo_OK(id);
		log.info("*******result:" + result);
		return result;
	}

	@GetMapping("/hystrix/timeout/{id}")
	@ResponseBody
//	@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") // 3秒钟以内就是正常的业务逻辑
//	})
	@HystrixCommand
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		String result = orderFeignService.paymentInfo_TimeOut(id);
		log.info("*******result:" + result);
		return result;
	}

	// 兜底方法
	public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
		return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
	}
    // 下面是 全局fallBack方法
    public String payment_Global_FallBackMethod() {
        return "Global异常处理信息，请稍后重试。。。!!!!";
    }
}
