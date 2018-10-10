package com.springcloud.test.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError") // 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，熔断方法直接返回了一个字符串
	public String getName(String name) {
		//restRemplate开启了负载均衡的功能
		String forObject = restTemplate.getForObject("http://EurekaServer/hi?name=" + name, String.class);
		if (!StringUtils.isEmpty(forObject)) {
			System.err.println("调用服务端成功");
		}
		return forObject;
	}

	public String hiError(String name) {
		System.err.println("调用服务端失败");
		return "hi," + name + ",sorry,error!";
	}

}
