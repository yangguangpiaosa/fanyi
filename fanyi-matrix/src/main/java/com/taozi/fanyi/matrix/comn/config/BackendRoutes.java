package com.taozi.fanyi.matrix.comn.config;

import com.jfinal.config.Routes;
import com.taozi.fanyi.admin.AdminRoutes;
import com.taozi.fanyi.home.HomeRoutes;
import com.taozi.fanyi.profile.ProfileRoutes;
import com.taozi.fanyi.support.web.comn.SupportRoutes;

public class BackendRoutes extends Routes {

	@Override
	public void config() {
		
		add(new SupportRoutes());
		
		add(new HomeRoutes());
		
		add(new ProfileRoutes());
		
		add(new AdminRoutes());
	}
	
}
