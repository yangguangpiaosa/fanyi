package com.taozi.fanyi.support.web.comn.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.taozi.fanyi.model.models.User;
import com.taozi.fanyi.support.web.comn.Constants;
import com.taozi.fanyi.utils.string.StringValidateUtil;

public class SessionInterceptor implements Interceptor {

	@SuppressWarnings("unchecked")
	@Override
	public void intercept(Invocation inv) {
		HttpServletRequest request = inv.getController().getRequest();
		HttpSession session = (HttpSession)request.getSession();
		if(null == session) {
			inv.getController().redirect("/toSignIn", false);
		} else {
			User user = (User)session.getAttribute(Constants.SESSION_USER);
			if(null != user && new StringValidateUtil(user.getId().toString()).notNull().isPassed()) {
				Set<String> auths = (Set<String>)session.getAttribute(Constants.SESSION_AUTH);
				if(auths.contains(inv.getActionKey())) {
					inv.invoke();
				} else {
					inv.getController().redirect("/toSignIn", false);
				}
			} else {
				inv.getController().redirect("/toSignIn", false);
			}
		}
	}

}
