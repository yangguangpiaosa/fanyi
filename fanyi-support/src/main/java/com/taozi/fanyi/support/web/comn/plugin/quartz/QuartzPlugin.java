package com.taozi.fanyi.support.web.comn.plugin.quartz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.jfinal.log.Log;
import com.jfinal.plugin.IPlugin;
import com.taozi.fanyi.support.web.comn.plugin.quartz.job.QuartzCronJob;
import com.taozi.fanyi.support.web.comn.plugin.quartz.job.QuartzJob;

public class QuartzPlugin implements IPlugin {

	private Log logger = Log.getLog(getClass());

	private String config = "/quartz.properties";

	private String jobs = "/jobs.properties";

	public boolean start() {
		try {
			// 加载配置文件
			InputStream in = this.getClass().getResourceAsStream(config);
			Properties properties = new Properties();
			properties.load(in);
			// 实例化
			QuartzKit.setSchedulerFactory(new StdSchedulerFactory(properties));
			// 获取Scheduler
			Scheduler sched = QuartzKit.getSchedulerFactory().getScheduler();
			// 内存,数据库的任务
			sched.start();
			// 属性文件中的任务
			startPropertiesJobs();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Can't start quartz plugin.", e);
		}
	}

	public boolean stop() {
		try {
			QuartzKit.getSchedulerFactory().getScheduler().shutdown();
			QuartzKit.setSchedulerFactory(null);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Can't stop quartz plugin.", e);
		}
	}

	@SuppressWarnings("unchecked")
	public void startPropertiesJobs() {
		InputStream in = this.getClass().getResourceAsStream(jobs);
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!properties.isEmpty()) {
			Enumeration<Object> enums = properties.keys();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement() + "";
				if (!key.startsWith("job")) {
					continue;
				}
				String[] keyArr = key.split("\\.");
				String jobClassKey = key.replace(keyArr[2], "class");
				String idKey = key.replace(keyArr[2], "id");
				String groupKey = key.replace(keyArr[2], "group");
				String cronKey = key.replace(keyArr[2], "cron");
				String enable = key.replace(keyArr[2], "enable");

				// see if the job is enabled
				if (!Boolean.valueOf(properties.getProperty(enable))) {
					continue;
				}
				Integer id = Integer.parseInt(properties.getProperty(idKey));
				String group = properties.getProperty(groupKey);
				QuartzKey quartzKey = new QuartzKey(id, keyArr[1], group == null ? keyArr[1] : group);
				QuartzJob quartzJob = QuartzKit.getJob(quartzKey);
				if (quartzJob != null) {
					logger.info("This  job  has been started," + quartzKey);
					continue;
				}
				String jobCron = properties.getProperty(cronKey);
				String jobClassName = properties.getProperty(jobClassKey);
				Class<Job> clazz = null;
				try {
					clazz = (Class<Job>) Class.forName(jobClassName);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				// start job
				new QuartzCronJob(quartzKey, jobCron, clazz).addParam("name", "Brody").start();
			}
		}
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	
}
