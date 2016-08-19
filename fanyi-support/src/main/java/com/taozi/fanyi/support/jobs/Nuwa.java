package com.taozi.fanyi.support.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jfinal.log.Log;
import com.taozi.fanyi.support.utils.velocity.StaticUtil;

/**
 * 女娲：中国上古神人
 * 成就：创造天地万物
 * Here we use it to create static stuff.
 */
public class Nuwa implements Job {
	
	private static final Log log = Log.getLog(Nuwa.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("TASK:: Nuwa will create everything soon...");
		//Map data = context.getJobDetail().getJobDataMap();
		//System.out.println("Hi,"+data.get("name")+"," + new Date().getTime());
		StaticUtil.generateStatic();
		log.info("TASK:: Nuwa's work is done.");
	}

}
