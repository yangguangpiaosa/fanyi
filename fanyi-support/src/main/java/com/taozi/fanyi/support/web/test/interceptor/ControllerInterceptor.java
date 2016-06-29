package com.taozi.fanyi.support.web.test.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ControllerInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Controller Interceptor...");
		inv.invoke();
	}

}
