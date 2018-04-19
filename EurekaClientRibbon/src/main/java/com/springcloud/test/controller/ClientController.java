package com.springcloud.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.test.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/getHi")
	public String getName(@RequestParam String name) {
		System.err.println("Ribbon开始调用服务端");
		return clientService.getName(name);
	}
}
