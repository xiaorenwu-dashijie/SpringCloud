package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
// @EnableDiscoveryClient
@EnableFeignClients // 加上@EnableFeignClients注解开启Feign的功能
// 如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
// Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
// Feign 采用的是基于接口的注解
// Feign 整合了ribbon
@EnableHystrixDashboard
public class EurekaClientFeignApplication {
	// 访问客户端： http://localhost:8764/getHi?name=aaa
	// 访问断路器仪表盘： http://localhost:8764/hystrix
	// 出现小熊画面，然后输入http://localhost:8764/hystrix.stream，在title里面随便输入，点击Monitor Stream按钮
	// 就能看到每个方法被访问的次数
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientFeignApplication.class, args);
		System.err.println("Feign客户端启动完成");
	}
}
