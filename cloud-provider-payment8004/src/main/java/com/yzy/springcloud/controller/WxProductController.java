package com.yzy.springcloud.controller;

import com.yzy.springcloud.entity.WxProduct;
import com.yzy.springcloud.service.WxProductService;
import com.yzy.springcloud.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wxProduct")
public class WxProductController {
	@Autowired
	private WxProductService wxProductService;

	@Value("${server.port}") // 获取bean的属性
	private String port;

	@RequestMapping("/zk")
	public R zk(@RequestBody WxProduct wxProduct) {
		return R.ok().put("port", port);
	}

	@PostMapping("/save")
	public R save(@RequestBody WxProduct wxProduct) {
		if (wxProductService.insert(wxProduct) == 1) {
			return R.ok();
		}
		return R.error("淇濆瓨澶辫触");
	}

	@GetMapping("/findByPage")
	public R findByPage() {

		return R.ok().put("data", wxProductService.findByPage()).put("port", port);
	}
}
