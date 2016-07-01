package com.taozi.fanyi.www.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	
	public void index() {
		//renderJsp("index.jsp");
		//renderJsp("index.html");
		renderJsp("index.html");
	}
	
	public void toSignIn() {
		redirect("/sign");
	}
	
}
