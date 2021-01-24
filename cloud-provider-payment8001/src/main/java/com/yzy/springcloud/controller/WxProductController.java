package com.yzy.springcloud.controller;

import com.yzy.springcloud.entity.WxProduct;
import com.yzy.springcloud.service.WxProductService;
import com.yzy.springcloud.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/wxProduct")
@Slf4j
public class WxProductController {
	@Autowired
	private WxProductService wxProductService;

	@Value("${server.port}") // 获取bean的属性
	private String port;

	@Resource
	private DiscoveryClient discoveryClient;

	@PostMapping("/save")
	public R save(@RequestBody WxProduct wxProduct) {
		if (wxProductService.insert(wxProduct) == 1) {
			return R.ok();
		}
		return R.error("保存失败");
	}

	@GetMapping("/findByPage")
	public R findByPage() {
		return R.ok().put("data", wxProductService.findByPage()).put("port", port);
	}

	@GetMapping("/lb")
	public R lb() {
		return R.ok().put("port", port);
	}

	@GetMapping("/discovery")
	public R discovery() {

		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			log.info(service);
		}
		List<ServiceInstance> instancesns = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance serviceInstance : instancesns) {
			log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t"
					+ serviceInstance.getPort() + "\t" + serviceInstance.getUri());
		}
		return R.ok();
	}

	@GetMapping(value = "/feign/timeout")
	public String paymentFeignTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return port;
	}

}
