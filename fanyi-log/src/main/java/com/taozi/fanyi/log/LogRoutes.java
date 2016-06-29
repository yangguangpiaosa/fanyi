package com.taozi.fanyi.log;

import com.jfinal.config.Routes;
import com.taozi.fanyi.log.controller.SysLogController;

public class LogRoutes extends Routes {

	@Override
	public void config() {
		add("/log", SysLogController.class);
	}

}
