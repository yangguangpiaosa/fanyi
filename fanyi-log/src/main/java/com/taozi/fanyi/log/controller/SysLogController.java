package com.taozi.fanyi.log.controller;

import com.jfinal.core.Controller;

public class SysLogController extends Controller {
	
	public void index() {
		//renderText("Log controller...");
		//renderJsp("log.jsp");
		setAttr("loginfo", "Logger");
		renderVelocity("log.vm");
	}
	
}
