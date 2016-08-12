package com.taozi.fanyi.www.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.taozi.fanyi.support.utils.velocity.FileRenderUtil;

public class IndexController extends Controller {
	
	public void index() {
		String classpath = FileRenderUtil.class.getResource("/").getPath().replace("WEB-INF/classes/", "");
		String view = classpath + "log/log.vm";
		Map<String, Object> params = new HashMap<String, Object> ();
		params.put("loginfo", "Logger");
		String file = classpath + File.separator + "log" + File.separator + "log.html";System.out.println(file);
		FileRenderUtil.renderFile(view, file, params);
		//renderJsp("index.jsp");
		//renderJsp("index.html");
		renderJsp("index.html");
	}
	
	public void toSignIn() {
		redirect("/sign");
	}
	
}
