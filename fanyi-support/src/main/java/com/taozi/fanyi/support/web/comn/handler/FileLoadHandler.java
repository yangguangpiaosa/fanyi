package com.taozi.fanyi.support.web.comn.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class FileLoadHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		if(target.startsWith("/file/") || target.startsWith("/pic/")) {
			int index = target.lastIndexOf(".");
			if (index != -1)
				target = target.substring(0, index);
		}
		next.handle(target, request, response, isHandled);
	}

}
