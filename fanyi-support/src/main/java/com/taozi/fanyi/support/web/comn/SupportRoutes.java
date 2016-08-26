package com.taozi.fanyi.support.web.comn;

import com.jfinal.config.Routes;
import com.taozi.fanyi.support.web.comn.controller.FileController;
import com.taozi.fanyi.support.web.comn.controller.ImgController;
import com.taozi.fanyi.support.web.comn.controller.UploadController;
import com.taozi.fanyi.support.web.system.controller.SignController;
import com.taozi.fanyi.support.web.test.controller.TestController;

public class SupportRoutes extends Routes {

	@Override
	public void config() {
		add("/upload", UploadController.class);
		add("/file", FileController.class);
		add("/img", ImgController.class);
		add("/test", TestController.class);
		add("/sign", SignController.class, "/system");
	}

}
