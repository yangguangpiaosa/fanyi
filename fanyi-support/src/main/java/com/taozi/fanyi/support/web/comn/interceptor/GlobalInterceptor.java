package com.taozi.fanyi.support.web.comn.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// do something here
		inv.invoke();
	}

}
