package com.taozi.fanyi.support.web.system.controller;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.taozi.fanyi.model.models.User;
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
			setSessionAttr(user.getId().toString(), user);
			log.info(getSessionAttr(user.getId().toString()).toString());
			//forward to admin action
			redirect("/home");
		} else {
			//forwardAction("/toSignIn");
			redirect("/toSignIn", false);
		}
	}
	
}
