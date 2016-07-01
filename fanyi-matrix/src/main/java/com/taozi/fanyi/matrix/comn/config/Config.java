package com.taozi.fanyi.matrix.comn.config;

import org.apache.log4j.Logger;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.taozi.fanyi.support.web.comn.interceptor.GlobalInterceptor;
import com.taozi.fanyi.support.web.comn.interceptor.LogInterceptor;

public class Config extends JFinalConfig {
	
	private static final Logger logger = Logger.getLogger(JFinalConfig.class);

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
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.addGlobalActionInterceptor(new LogInterceptor());
		me.addGlobalActionInterceptor(new GlobalInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		
	}
	
	@Override
	public void afterJFinalStart() {
		super.afterJFinalStart();
		logger.info("================== SYSTEM STARTED ==================");
	}

	@Override
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
		logger.info("================== SYSTEM STOPPED ==================");
	}

	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("db.url"), PropKit.get("db.username"), PropKit.get("db.password").trim(), PropKit.get("db.driver"));
	}
	
	public static void main(String [] args) {
		//Disable this feature, using tomcat 7.0.47
		//JFinal.start("src/main/webapp", 8088, "/matrix", 5);
	}

}
