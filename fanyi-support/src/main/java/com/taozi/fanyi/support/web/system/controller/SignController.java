package com.taozi.fanyi.support.web.system.controller;

import com.jfinal.core.Controller;

public class SignController extends Controller {
	
	public void index() {
		renderJsp("signIn.jsp");
	}
	
	public void signIn() {
		String email = getPara("email");
		String password = getPara("password");
		if(email.equals("a@a.com") && password.equals("111111")) {
			//forward to admin action
			redirect("/admin");
		} else {
			//forwardAction("/toSignIn");
			redirect("/toSignIn", false);
		}
	}
	
}
