package com.taozi.fanyi.support.web.test.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.taozi.fanyi.support.web.test.interceptor.ActionInterceptor;
import com.taozi.fanyi.support.web.test.interceptor.ControllerInterceptor;
import com.taozi.fanyi.support.web.test.interceptor.InjectInterceptor;
import com.taozi.fanyi.support.web.test.service.TestService;

@Before(ControllerInterceptor.class)
public class TestController extends Controller {
	
	@Before(ActionInterceptor.class)
	public void index() {
		//renderText("Test Controller...");
		renderJsp("test.jsp");
		//setAttr("name", "Test123456");
		//renderVelocity("test.vm");
	}
	
	@Before(ActionInterceptor.class)
	public void upd() {
		redirect("/test");
	}
	
	@Clear({ControllerInterceptor.class})
	@Before(ActionInterceptor.class)
	public void login() {
		renderText("Login...");
	}
	
	public void test() {
		//test service interceptor
		TestService ts = enhance(TestService.class);
		ts.handleOrders();
		renderText("Test service");
	}
	
	public void inject() {
		TestService ts = enhance(TestService.class, InjectInterceptor.class);
		ts.handleOrders();
		renderText("Test inject");
	}
	
}
