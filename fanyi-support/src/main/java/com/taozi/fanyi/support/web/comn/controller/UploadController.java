package com.taozi.fanyi.support.web.comn.controller;

import java.io.File;
import java.io.IOException;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.taozi.fanyi.utils.file.FileUtil;
import com.taozi.fanyi.utils.string.StringUtil;

public class UploadController extends Controller {

	public void index() {
		renderJsp("upload.jsp");
	}

	public void upd() {
		UploadFile uploadFile = null;
		try {
			uploadFile = this.getFile();
			if(uploadFile == null) {
				renderHtml("no file,<a href=\"./\">back</a>");
			} else {
				String fileName = uploadFile.getOriginalFileName();
				File file = uploadFile.getFile();
				File t = new File("C:\\_code\\" + fileName + StringUtil.getDateTimeString());
				try {
					t.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				FileUtil.fileChannelCopy(file, t);
				file.delete();
				renderHtml("success,<a href=\"./\">back</a>");
			}
		} catch (Exception e1) {
			renderHtml("check: file size < 2M,<a href=\"./\">back</a>");
		}
		
	}

}
