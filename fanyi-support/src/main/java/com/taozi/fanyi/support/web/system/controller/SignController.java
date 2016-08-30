package com.taozi.fanyi.support.web.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
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
		redirect("index.html");
	}
	
	private void initSession(User user) {
		setSessionAttr(Constants.SESSION_USER, user);
		HttpSession session = this.getSession();
		session.setMaxInactiveInterval(Constants.SESSION_TIME_OUT);
		
		//get user authority
		List<Record> objs = Db.find("select *, 'aaa' as ccc from user where email=?", "admin@admin.com");
		System.out.println(objs.get(0).getStr("ccc"));
	}
	
}
