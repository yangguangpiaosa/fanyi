package com.taozi.fanyi.utils.string;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	public static String getDateTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	public static void main(String [] args) {
		System.out.println(StringUtil.getDateTimeString());
	}
	
}
