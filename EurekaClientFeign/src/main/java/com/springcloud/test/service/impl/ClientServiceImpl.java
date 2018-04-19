package com.springcloud.test.service.impl;

import org.springframework.stereotype.Component;

import com.springcloud.test.service.ClientService;

@Component
public class ClientServiceImpl implements ClientService {

	@Override
	public String getName(String name) {
		return "Sorry: no " + name;
	}

}
