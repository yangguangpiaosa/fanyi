package com.taozi.fanyi.support.utils.velocity;

import java.util.List;
import java.util.Map;

public class NoticeGenerator implements Generator {

	@Override
	public Map<String, Object> getPageData(Map<String, Object> params) {
		return null;
	}
	
	@Override
	public List<String> getIds(Map<String, Object> params) {
		return null;
	}

	@Override
	public List<Item> getItemsData(Map<String, Object> params, String basePath, Generator generator, Map<String, String> pageMap) {
		return null;
	}

	@Override
	public void generateStatic(Map<String, Object> params, String basePath, String pageName, Map<String, String> pageMap) {
	}

}
