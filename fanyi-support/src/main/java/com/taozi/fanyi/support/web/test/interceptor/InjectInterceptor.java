package com.taozi.fanyi.support.web.test.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class InjectInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("Inject interceptor...");
		inv.invoke();
	}

}
