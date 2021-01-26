package com.yzy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
	@Value("${config.info}")
	private String config;

	@RequestMapping("/hello")
	public String from() {
		return this.config;
	}
}
