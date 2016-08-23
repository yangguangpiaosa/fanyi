package com.taozi.fanyi.support.web.comn.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class StaticHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		
		System.out.println("Static Handler start ...");
		next.handle(target, request, response, isHandled);
		
	}

}
