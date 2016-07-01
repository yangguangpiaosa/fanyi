package com.taozi.fanyi.matrix.comn.config;

import com.jfinal.config.Routes;
import com.taozi.fanyi.www.WwwRoutes;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		
		add(new WwwRoutes());
		
	}
	
}
