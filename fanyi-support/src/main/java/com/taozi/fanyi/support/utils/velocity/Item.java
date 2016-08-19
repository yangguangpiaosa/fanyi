package com.taozi.fanyi.support.utils.velocity;

public class Item {
	
	private String id;
	private String pageName;
	private String title;
	
	public Item(String id, String pageName, String title) {
		this.id = id;
		this.pageName = pageName;
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
