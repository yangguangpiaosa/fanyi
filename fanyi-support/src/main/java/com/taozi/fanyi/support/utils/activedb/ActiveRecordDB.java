package com.taozi.fanyi.support.utils.activedb;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.taozi.fanyi.model.models._MappingKit;

public class ActiveRecordDB {
	
	private static DruidPlugin dp = null;
	private static ActiveRecordPlugin arp = null;
	
	public static void startActiveRecordDB() {
		PropKit.use("config.properties");
		// DruidPlugin
		dp = new DruidPlugin(PropKit.get("db.url"), PropKit.get("db.username"), PropKit.get("db.password").trim(), PropKit.get("db.driver"));
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		dp.start();
		
		// ActiveRecordPlugin
		arp = new ActiveRecordPlugin("activeRecordDB", dp);
		arp.setShowSql(true);
		arp.setDialect(new MysqlDialect());
		_MappingKit.mapping(arp);
		arp.start();
	}
	
	public static void stopActiveRecordDB() {
		if(arp != null) {
			arp.stop();
			arp = null;
		}
		if(dp != null) {
			dp.stop();
			dp = null;
		}
	}
	
}
