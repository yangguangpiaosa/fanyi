package com.taozi.fanyi.support.web.system.controller;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.taozi.fanyi.model.models.User;
import com.taozi.fanyi.support.web.comn.Constants;
import com.taozi.fanyi.utils.encrypt.Encryptor;

public class SignController extends Controller {
	
	private static final Log log = Log.getLog(SignController.class);
	
	public void index() {
		renderJsp("signIn.jsp");
	}
	
	public void signIn() {
		String email = getPara("email");
		String password = getPara("password");
		long count = Db.queryLong("select count(id) from user where email = ? and user_pass = ?", email, Encryptor.base64AfterMd5(password));
		User user = User.dao.findFirst("select * from user where email = ? and user_pass = ?", email, Encryptor.base64AfterMd5(password));
		if(count == 1 && null != user) {
			log.info(user.getUserName() + " - " + user.getEmail());
			setSessionAttr(Constants.SESSION_USER, user);
			HttpSession session = this.getSession();
			session.setMaxInactiveInterval(Constants.SESSION_TIME_OUT);
			log.info(getSessionAttr(Constants.SESSION_USER).toString());
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
	
}
