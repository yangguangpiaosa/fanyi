package com.taozi.fanyi.matrix.comn.config;

import com.jfinal.config.Routes;
import com.taozi.fanyi.log.LogRoutes;
import com.taozi.fanyi.support.web.comn.SupportRoutes;
import com.taozi.fanyi.support.web.system.controller.InitController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/", InitController.class);
		
		add(new SupportRoutes());
		
		add(new LogRoutes());
	}
	
}
