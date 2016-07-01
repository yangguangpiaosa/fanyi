package com.taozi.fanyi.www;

import com.jfinal.config.Routes;
import com.taozi.fanyi.www.controller.IndexController;

public class WwwRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
	}

}
