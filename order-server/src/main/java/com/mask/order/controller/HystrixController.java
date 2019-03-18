package com.mask.order.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
	
//	@HystrixCommand(fallbackMethod = "fallback")
	//超时配置
	@HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
	@GetMapping("/getProductInfoList")
	public String getProductInfoList() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://127.0.0.1:8808/product/listForOrder",
				Arrays.asList("157875196366160022"),
				String.class);
	}
	
	private String fallback() {
		return "太拥挤了请稍后再试";
	}
	
	private String defaultFallback() {
		return "默认方法，太拥挤了,请稍后再试~~~~~";
	}
}
