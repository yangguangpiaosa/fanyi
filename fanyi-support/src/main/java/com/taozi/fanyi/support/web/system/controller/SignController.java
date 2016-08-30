package com.taozi.fanyi.support.web.system.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.taozi.fanyi.model.models.User;
import com.taozi.fanyi.support.web.comn.Constants;

public class SignController extends Controller {
	
	private static final Log log = Log.getLog(SignController.class);
	
	public void index() {
		renderJsp("signIn.jsp");
	}
	
	public void signIn() {
		log.info("Sign in ...");
		User signUser = getBean(User.class);
		long count = signUser.getCount();
		User user = signUser.getSignInUser();
		if(count == 1 && null != user) {
			initSession(user);
			//forward to admin action
			redirect("/home");
		} else {
			//forwardAction("/toSignIn");
			redirect("/toSignIn", false);
		}
	}
	
	public void signOut() {
		removeSessionAttr(Constants.SESSION_USER);
		removeSessionAttr(Constants.SESSION_AUTH);
		redirect("/");
	}
	
	private void initSession(User user) {
		setSessionAttr(Constants.SESSION_USER, user);
		HttpSession session = this.getSession();
		session.setMaxInactiveInterval(Constants.SESSION_TIME_OUT);
		
		//get user authority
		Set<String> auths = user.getAuth();
		setSessionAttr(Constants.SESSION_AUTH, auths);
	}
	
}
