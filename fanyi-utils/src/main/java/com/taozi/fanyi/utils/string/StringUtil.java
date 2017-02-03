package com.taozi.fanyi.utils.string;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.taozi.fanyi.utils.Constants;

public class StringUtil {
	
	/**
	 * 日期格式化字符串
	 * @return
	 */
	public static String getDateTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	/**
	 * 随机字符串
	 * @param digit
	 * @param onlyNums
	 * @return
	 */
	public static String getRandomSequence(int digit, boolean onlyNums) {
		String res = "";
		for(int i = 1; i <= digit; i++) {
			if(onlyNums)
				res += Constants.NUMS[(int)Math.floor(Math.random()*10)];
			else
				res += Constants.CHARS[(int)Math.floor(Math.random()*62)];
		}
		return res;
	}
	
	public static void main(String [] args) {
		System.out.println(StringUtil.getDateTimeString());
		System.out.println(StringUtil.getRandomSequence(16, true));
		System.out.println(StringUtil.getRandomSequence(16, false));
	}
	
}
