package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServerApplication {
	//http://localhost:8762/hi?name=forezp
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
		System.err.println("服务端1注册完成");
	}
}
