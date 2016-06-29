package com.taozi.fanyi.support.web.comn.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class LogInterceptor implements Interceptor {
	
	private static final Logger logger = Logger.getLogger(LogInterceptor.class);

	@Override
	public void intercept(Invocation inv) {
		HttpServletRequest request = inv.getController().getRequest();
		String userIp = getIpAddr(request);
		logger.info("***** User IP: " + userIp);
		String actionKey = inv.getActionKey();
		long start = System.currentTimeMillis();
		inv.invoke();
		long end = System.currentTimeMillis();
		logger.info("***** Visit URL: " + actionKey + ", Time Cost: " + (end - start) + "ms.");
	}
	
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        //多次反向代理后会有多个IP值，第一个为真实IP
        int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
             return request.getRemoteAddr();
        }
	}

}
