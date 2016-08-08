package com.taozi.fanyi.home.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.taozi.fanyi.support.web.comn.interceptor.SessionInterceptor;

@Before(SessionInterceptor.class)
public class HomeController extends Controller {
	
	public void index() {
		renderJsp("home.jsp");
	}
	
}
