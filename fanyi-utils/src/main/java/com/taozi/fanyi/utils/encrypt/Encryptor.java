package com.taozi.fanyi.utils.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.taozi.fanyi.utils.string.StringValidateUtil;

public class Encryptor {
	
	public static String md5(String input) {
		if(new StringValidateUtil(input).notNull().isPassed())
			return DigestUtils.md5Hex(input);
		else
			return "";
	}
	
	public static String sha1(String input) {
		if(new StringValidateUtil(input).notNull().isPassed())
			return DigestUtils.sha1Hex(input);
		else
			return "";
	}
	
	public static String encodeBase64(String input) {
		if(new StringValidateUtil(input).notNull().isPassed())
			return new String(Base64.encodeBase64(input.getBytes(), true)).trim();
		else
			return "";
	}
	
	public static String decodeBase64(String input) {
		if(new StringValidateUtil(input).notNull().isPassed())
			return new String(Base64.decodeBase64(input.getBytes()));
		else
			return "";
	}
	
	public static String base64AfterMd5(String input) {
		return Encryptor.encodeBase64(Encryptor.md5(input));
	}
	
	public static void main(String [] args) {
		System.out.println(Encryptor.md5("admin"));
		System.out.println(Encryptor.sha1("admin"));
		System.out.println(Encryptor.encodeBase64("admin"));
		System.out.println(Encryptor.base64AfterMd5("admin123"));
		System.out.println(Encryptor.decodeBase64("YWRtaW4="));
		System.out.println("21232f297a57a5a743894a0e4a801fc3".length());
	}
	
}
