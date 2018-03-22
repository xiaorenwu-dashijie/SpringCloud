package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaCenterApplication {
	//http://localhost:8761/
	public static void main(String[] args) {
		SpringApplication.run(EurekaCenterApplication.class, args);
		System.err.println("注册中心启动完成");
	}
}
