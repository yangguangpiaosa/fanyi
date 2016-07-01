package com.taozi.fanyi.matrix.comn.config;

import com.jfinal.config.Routes;
import com.taozi.fanyi.log.LogRoutes;
import com.taozi.fanyi.support.web.comn.SupportRoutes;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		
		add(new SupportRoutes());
		
		add(new LogRoutes());
	}
	
}
