package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServerSecondApplication {
	//http://localhost:8763/hi?name=aaa
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSecondApplication.class, args);
		System.err.println("服务端2注册完成");
	}
}
