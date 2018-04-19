package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class EurekaZuulApplication {
	//http://localhost:8766/api-ribbon/getHi?name=aaa&token=22
	//http://localhost:8766/api-feign/getHi?name=aaa&token=22
	public static void main(String[] args) {
		//客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务网关（zuul集群），然后再到具体的服务
		SpringApplication.run(EurekaZuulApplication.class, args);
		System.err.println("路由网关zuul启动成功");
	}
}
