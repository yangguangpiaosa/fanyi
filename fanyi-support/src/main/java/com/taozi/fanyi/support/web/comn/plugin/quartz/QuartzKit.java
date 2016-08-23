package com.taozi.fanyi.support.web.comn.plugin.quartz;

import java.util.ArrayList;
import java.util.List;

import org.quartz.SchedulerFactory;

import com.taozi.fanyi.support.web.comn.plugin.quartz.job.QuartzJob;

/**
 * Created by wangrenhui on 14-4-21.
 */
public class QuartzKit {

	private static SchedulerFactory schedulerFactory;

	private static List<QuartzJob> quartzJobs = new ArrayList<QuartzJob>();

	private QuartzKit() {
	}

	public static QuartzJob getJob(QuartzKey quartzKey) {
		for (QuartzJob quartzJob : quartzJobs) {
			if (quartzJob.getQuartzKey().equals(quartzKey)) {
				return quartzJob;
			}
		}
		return null;
	}

	public static void stopJob(QuartzKey quartzKey) {
		for (QuartzJob quartzJob : quartzJobs) {
			if (quartzJob.getQuartzKey().equals(quartzKey)) {
				quartzJob.stop();
			}
		}
	}

	public static void pauseJob(QuartzKey quartzKey) {
		for (QuartzJob quartzJob : quartzJobs) {
			if (quartzJob.getQuartzKey().equals(quartzKey)) {
				quartzJob.pause();
			}
		}
	}

	public static void resumeJob(QuartzKey quartzKey) {
		for (QuartzJob quartzJob : quartzJobs) {
			if (quartzJob.getQuartzKey().equals(quartzKey)) {
				quartzJob.resume();
			}
		}
	}

	public static SchedulerFactory getSchedulerFactory() {
		return schedulerFactory;
	}

	public static void setSchedulerFactory(SchedulerFactory schedulerFactory) {
		QuartzKit.schedulerFactory = schedulerFactory;
	}

	public static List<QuartzJob> getQuartzJobs() {
		return quartzJobs;
	}

	public static void setQuartzJobs(List<QuartzJob> quartzJobs) {
		QuartzKit.quartzJobs = quartzJobs;
	}

	public static void addQuartzJob(QuartzJob startedJob) {
		QuartzKit.quartzJobs.add(startedJob);
	}

	public static void removeQuartzJob(QuartzJob startedJob) {
		QuartzKit.quartzJobs.remove(startedJob);
	}
}