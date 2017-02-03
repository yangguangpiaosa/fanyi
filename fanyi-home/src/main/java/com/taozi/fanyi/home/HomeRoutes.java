package com.taozi.fanyi.home;

import com.jfinal.config.Routes;
import com.taozi.fanyi.home.main.controller.HomeController;
import com.taozi.fanyi.home.topic.controller.TopicController;

public class HomeRoutes extends Routes {

	@Override
	public void config() {
		add("/home", HomeController.class);
		add("/topic", TopicController.class);
	}

}
