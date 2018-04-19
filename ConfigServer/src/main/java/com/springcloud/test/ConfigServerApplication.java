package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {
	// http://localhost:8888/config-client/dev
	// 这个请求路径需要到github上看一下文件名称
	// http请求地址和资源文件映射如下:
	// /{application}/{profile}[/{label}]
	// /{application}-{profile}.yml
	// /{label}/{application}-{profile}.yml
	// /{application}-{profile}.properties
	// /{label}/{application}-{profile}.properties
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		System.err.println("ConfigServer启动成功");
	}
}
