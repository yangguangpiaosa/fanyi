package com.taozi.fanyi.support.web.system.controller;

import com.jfinal.core.Controller;

public class InitController extends Controller {
	
	public void index() {
		//renderJsp("index.jsp");
		//renderJsp("index.html");
		renderJsp("index.html");
	}
	
	public void toSignIn() {
		redirect("/sign");
	}
	
}
