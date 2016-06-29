package com.taozi.fanyi.support.web.test.service;

import com.jfinal.aop.Before;
import com.taozi.fanyi.support.web.test.interceptor.ServiceInterceptor;

public class TestService {
	
	@Before(ServiceInterceptor.class)
	public void handleOrders() {
		System.out.println("Some logic here.");
	}
	
}
