package com.taozi.fanyi.support.utils.velocity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsGenerator implements Generator {

	@Override
	public Map<String, Object> getPageData(Map<String, Object> params) {
		Map<String, Object> dataMap = new HashMap<String, Object> ();
		dataMap.put("id", params.get("id"));
		return dataMap;
	}
	
	@Override
	public List<String> getIds(Map<String, Object> params) {
		List<String> ids = new ArrayList<String> ();
		ids.add("1");
		ids.add("2");
		return ids;
	}

	@Override
	public List<Item> getItemsData(Map<String, Object> params, String basePath, Generator generator, Map<String, String> pageMap) {
		List<Item> items = new ArrayList<Item> ();
		Item item = new Item("index", pageMap.get("index"), "index");
		items.add(item);
		return items;
	}

	@Override
	public void generateStatic(Map<String, Object> params, String basePath, String pageName, Map<String, String> pageMap) {
		Map<String, Object> dataMap = getPageData(params);
		
		Map<String, Object> pas = new HashMap<String, Object> ();
		//pas.put(key, value);
		List<Item> newsItems = getItemsData(pas, basePath, null, pageMap);
		dataMap.put("items", newsItems);
		
		//put into velocity params, generate html
		//String view = StaticUtil.class.getResource("").getPath()+"vm/news.vm";
		String view = StaticUtil.class.getResource("/").getPath().replace("WEB-INF/classes", "") + "tpl/news.vm";
		FileRenderUtil.renderFile(view, basePath + pageName, dataMap);
	}

}
