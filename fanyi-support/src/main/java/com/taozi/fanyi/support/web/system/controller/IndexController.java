package com.taozi.fanyi.support.web.system.controller;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;

public class IndexController extends Controller {
	
	private static final Log log = Log.getLog(IndexController.class);
	
	public void index() {
		log.info("################################## Test www log...");
		//renderJsp("index.jsp");
		renderJsp("index.html");
	}
	
	public void toSignIn() {
		redirect("/sign");
	}
	
}
