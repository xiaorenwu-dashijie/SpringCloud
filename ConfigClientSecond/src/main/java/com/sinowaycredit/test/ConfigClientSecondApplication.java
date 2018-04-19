package com.sinowaycredit.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope // @RefreshScope，这个注解一定要注解到获取配制文件的类上，这样子的话springboot才会自动刷新配制文件里面的属性值，reflash才起作用。
public class ConfigClientSecondApplication {

	// http://localhost:8882/hi
	// 配置完消息总线，需要发送POST请求：http://localhost:8881/bus/refresh
	// 才能刷新配置文件的属性值，发送GET请求会报错
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientSecondApplication.class, args);
		System.err.println("ConfigClientSecond启动成功");
	}

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi() {
		return foo;
	}
}
