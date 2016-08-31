package com.taozi.fanyi.support.web.comn.controller;

import java.io.File;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

public class FileController extends Controller {
	
	protected static final String BATH_PATH = "C:\\_code";
	
	public void index() {
		String fileId = getPara(0);
		if(StrKit.isBlank(fileId)) {
			renderFile(new File(""));//some default file
		}
		String file = BATH_PATH + File.separator + getFullName(fileId);
		renderFile(new File(file));
	}
	
	protected String getFullName(String fileId) {
		System.out.println(fileId);
		return "bak.png";
	}
	
}
