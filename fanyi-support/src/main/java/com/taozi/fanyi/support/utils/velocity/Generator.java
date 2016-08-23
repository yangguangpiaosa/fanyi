package com.taozi.fanyi.support.utils.velocity;

import java.util.List;
import java.util.Map;

public interface Generator {
	
	public Map<String, Object> getPageData(Map<String, Object> params);
	
	public List<String> getIds(Map<String, Object> params);
	
	public List<Item> getItemsData(Map<String, Object> params, String basePath, Generator generator, Map<String, String> pageMap);
	
	public void generateStatic(Map<String, Object> params, String basePath, String pageName, Map<String, String> pageMap);
	
}
