package com.taozi.fanyi.support.utils.velocity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.taozi.fanyi.utils.string.StringUtil;

public class StaticUtil {
	
	public static void generateStatic() {
		System.out.println("Generator started.");
		long start = System.currentTimeMillis();
		
		String path = "C:\\_code\\gen\\";
		File staticDir = new File(path + "static");
		if(!staticDir.exists()) {
			staticDir.mkdirs();
		}
		String filePostfix = StringUtil.getDateTimeString();
		File file = new File(path + filePostfix);
		file.mkdirs();
		String basePath = path + filePostfix + "\\";
		String pageName = "index.html";
		Map<String, String> pageMap = new HashMap<String, String> ();
		pageMap.put("index", pageName);
		Map<String, Object> params = new HashMap<String, Object> ();
		new MainGenerator().generateStatic(params, basePath, pageName, pageMap);
		try {
			FileUtils.cleanDirectory(new File(path + "static"));
			FileUtils.deleteDirectory(new File(path + "static"));
			file.renameTo(new File(path + "static"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Pages generated in " + (end-start) + " ms.");
		System.out.println("Generator ended.");
	}
	
	public static void main(String [] args) {
		StaticUtil.generateStatic();
	}
	
}
