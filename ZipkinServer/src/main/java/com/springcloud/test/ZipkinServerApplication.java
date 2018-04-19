package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer // 开启ZipkinServer的功能
@SpringBootApplication
public class ZipkinServerApplication {

	// http://localhost:9411/
	// 微服务数量逐渐增大，服务间的依赖关系越来越复杂，怎么分析它们之间的调用关系及相互的影响？
	// 此时就用到了服务链路追踪，及Zipkin
	// zipkin作用
	// 全链路追踪工具（查看依赖关系）
	// 查看每个接口、每个service的执行速度（定位问题发生点或者寻找性能瓶颈）
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
		System.err.println("服务追踪启动成功");
	}
}
