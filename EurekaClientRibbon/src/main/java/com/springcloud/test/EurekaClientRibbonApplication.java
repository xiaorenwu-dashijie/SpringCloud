package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 通过@EnableDiscoveryClient向服务中心注册
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientRibbonApplication {
	// 访问客户端：  http://localhost:8765/getHi?name=aaa
	// 访问断路器仪表盘：  http://localhost:8765/hystrix
	// 出现小熊画面，然后输入http://localhost:8765/hystrix.stream，在title里面随便输入，点击Monitor Stream按钮
	// 就能看到每个方法被访问的次数
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
		System.err.println("Ribbon客户端启动成功");
	}

	@Bean // 向程序的ioc注入一个bean: restTemplate
	@LoadBalanced // 通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
