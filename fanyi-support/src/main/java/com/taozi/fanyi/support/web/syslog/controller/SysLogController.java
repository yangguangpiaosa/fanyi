package com.taozi.fanyi.support.web.syslog.controller;

import com.jfinal.core.Controller;

public class SysLogController extends Controller {
	
	public void index() {
		renderJsp("log.jsp");
	}
	
}
