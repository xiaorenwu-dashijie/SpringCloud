package com.springcloud.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcloud.test.service.impl.ClientServiceImpl;

//定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
@FeignClient(value = "EurekaServer", fallback = ClientServiceImpl.class)
public interface ClientService {
	// Feign 采用的是基于接口的注解
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String getName(@RequestParam(value = "name") String name);
}
