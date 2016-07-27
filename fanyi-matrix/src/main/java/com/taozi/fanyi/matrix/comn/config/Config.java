package com.taozi.fanyi.matrix.comn.config;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.druid.IDruidStatViewAuth;
import com.taozi.fanyi.model.models._MappingKit;
import com.taozi.fanyi.support.web.comn.handler.StaticHandler;
import com.taozi.fanyi.support.web.comn.interceptor.GlobalInterceptor;
import com.taozi.fanyi.support.web.comn.interceptor.LogInterceptor;

public class Config extends JFinalConfig {
	
	private static final Log log = Log.getLog(JFinalConfig.class);

	@Override
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());
		me.add(new BackendRoutes());
	}

	@Override
	public void configPlugin(Plugins me) {
		/*C3p0Plugin c3p0Plugin = createC3p0Plugin();
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		//设置HSQLDB数据库方言，不设置默认为mysql方言
		arp.setDialect(new AnsiSqlDialect());
		_MappingKit.mapping(arp);
		me.add(arp);*/
		
		// DruidPlugin
		DruidPlugin dp = new DruidPlugin(PropKit.get("db.url"), PropKit.get("db.username"), PropKit.get("db.password").trim(), PropKit.get("db.driver"));
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		me.add(dp);
		
		// ActiveRecordPlugin
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setShowSql(true);
		_MappingKit.mapping(arp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.addGlobalActionInterceptor(new LogInterceptor());
		me.addGlobalActionInterceptor(new GlobalInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new StaticHandler());
		//Druid Monitor
		DruidStatViewHandler dvh = new DruidStatViewHandler("/druid", new IDruidStatViewAuth() {

			@Override
			public boolean isPermitted(HttpServletRequest request) {
				// 这里只是简单的判断访问者是否登录，还可以做更加细致的权限控制
				/*User user=(User) request.getSession().getAttribute("user");
				if(user == null) {
					return false;
				}
				return "admin".equals(user.getStr("uname"));*/
				return true;
			}
			
		});
		me.add(dvh);
	}
	
	@Override
	public void afterJFinalStart() {
		super.afterJFinalStart();
		log.info("================== SYSTEM STARTED ==================");
	}

	@Override
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
		log.info("================== SYSTEM STOPPED ==================");
	}

	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("db.url"), PropKit.get("db.username"), PropKit.get("db.password").trim(), PropKit.get("db.driver"));
	}
	
	public static void main(String [] args) {
		//Disable this feature, using tomcat 7.0.47
		//JFinal.start("src/main/webapp", 8088, "/matrix", 5);
	}

}
