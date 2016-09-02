package com.taozi.fanyi.home;

import com.jfinal.config.Routes;
import com.taozi.fanyi.home.main.controller.HomeController;

public class HomeRoutes extends Routes {

	@Override
	public void config() {
		add("/home", HomeController.class);
	}

}
