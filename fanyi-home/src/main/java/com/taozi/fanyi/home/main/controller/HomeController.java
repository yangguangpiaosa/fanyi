package com.taozi.fanyi.home.main.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.taozi.fanyi.support.web.comn.interceptor.SessionInterceptor;

@Before(SessionInterceptor.class)
public class HomeController extends Controller {
	
	private static final Log log = Log.getLog(HomeController.class);
	
	public void index() {
		log.info("################################## Test home log...");
		renderJsp("home.jsp");
	}
	
}
