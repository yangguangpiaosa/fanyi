package com.taozi.fanyi.support.utils.velocity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taozi.fanyi.model.models.User;
import com.taozi.fanyi.utils.string.StringUtil;

public class MainGenerator implements Generator {

	@Override
	public Map<String, Object> getPageData(Map<String, Object> params) {
		Map<String, Object> dataMap = new HashMap<String, Object> ();
		//ActiveRecordDB.startActiveRecordDB();
		User user = User.dao.findById(1);
		dataMap.put("name", user.getUserName());
		//ActiveRecordDB.stopActiveRecordDB();
		return dataMap;
	}
	
	@Override
	public List<String> getIds(Map<String, Object> params) {
		return null;
	}

	@Override
	public List<Item> getItemsData(Map<String, Object> params, String basePath, Generator generator, Map<String, String> pageMap) {
		List<Item> itemsData = new ArrayList<Item> ();
		
		String symbol = "";
		Item item = null;
		String pageName = "";
		List<String> ids = generator.getIds(params);
		if(ids != null && ids.size() != 0) {
			for(String id : ids) {
				symbol = generator.getClass().getName() + ":" + id;
				if(pageMap.containsKey(symbol)) {
					item = new Item(""+id, ""+pageMap.get(symbol), ""+id);
				} else {
					Map<String, Object> ps = new HashMap<String, Object> ();
					ps.put("id", id);
					pageName = StringUtil.getDateTimeString()+"_"+id+".html";
					pageMap.put(symbol, pageName);
					generator.generateStatic(ps, basePath, pageName, pageMap);
					item = new Item(""+id, ""+pageName, "page-"+id);
				}
				itemsData.add(item);
			}
		}
		return itemsData;
	}

	@Override
	public void generateStatic(Map<String, Object> params, String basePath, String pageName, Map<String, String> pageMap) {
		
		//get business data to be shown on this page
		Map<String, Object> dataMap = getPageData(params);
		
		//get sub pages link data to be shown on this page, e.g. get latest 10 news
		Map<String, Object> pas = new HashMap<String, Object> ();
		//pas.put(key, value);
		List<Item> newsItems = getItemsData(pas, basePath, new NewsGenerator(), pageMap);
		dataMap.put("news", newsItems);
		
		//put into velocity params, generate html
		//String view = StaticUtil.class.getResource("").getPath()+"vm/log.vm";
		String view = StaticUtil.class.getResource("/").getPath().replace("WEB-INF/classes", "") + "log/log.vm";
		FileRenderUtil.renderFile(view, basePath + pageName, dataMap);
		
	}

}
