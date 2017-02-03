package com.taozi.fanyi.home.topic.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.taozi.fanyi.model.models.BizTopic;
import com.taozi.fanyi.model.models.User;
import com.taozi.fanyi.support.web.comn.Constants;
import com.taozi.fanyi.support.web.comn.interceptor.SessionInterceptor;

@Before(SessionInterceptor.class)
public class TopicController extends Controller {
	
	public void index() {
		List<BizTopic> topics = BizTopic.dao.find("select * from biz_topic");
		setAttr("topics", topics);
		renderJsp("topic.jsp");
	}
	
	public void add() {
		renderJsp("add.jsp");
	}
	
	public void addSave() {
		BizTopic topic = getBean(BizTopic.class, "topic");
		topic.setUserId(((User)this.getSessionAttr(Constants.SESSION_USER)).getId());
		topic.save();
		System.out.println("New user id is: "+topic.getId());
		redirect("/topic");
	}
	
	public void edit() {
		int topicId = this.getParaToInt(0);
		BizTopic topic = BizTopic.dao.findById(topicId);
		setAttr("topic", topic);
		renderJsp("edit.jsp");
	}
	
	public void editSave() {
		BizTopic topic = getBean(BizTopic.class, "topic");
		topic.update();
		System.out.println("User id is: "+topic.getId());
		redirect("/topic");
	}
	
	public void delete() {
		int topicId = this.getParaToInt(0);
		BizTopic.dao.deleteById(topicId);
		redirect("/topic");
	}
	
}
