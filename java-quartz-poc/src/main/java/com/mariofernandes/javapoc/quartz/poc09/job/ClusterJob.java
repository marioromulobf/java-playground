package com.mariofernandes.javapoc.quartz.poc09.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class ClusterJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(ClusterJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        var scheduler = context.getScheduler();
        var thread = Thread.currentThread();
        var jobKey = context.getJobDetail().getKey();
        var triggerKey = context.getTrigger().getKey();

        try {
            var schedulerName = scheduler.getSchedulerName();
            var schedulerInstanceId = scheduler.getSchedulerInstanceId();
            var startTime = LocalDateTime.now();

            log.info("Executing job={} trigger={} thread={} virtual={} time={} scheduler={} instance={}",
                    jobKey, triggerKey, thread.getName(), thread.isVirtual(), startTime, schedulerName,
                    schedulerInstanceId);
            Thread.sleep(10_000);
        } catch (InterruptedException | SchedulerException e) {
            log.error("Job execution interrupted for job key: {}", jobKey, e);
            Thread.currentThread().interrupt();
        } finally {
            var endTime = LocalDateTime.now();
            log.info("Finished executing job={} trigger={} thread={} time={}",
                    jobKey, triggerKey, thread.getName(), endTime);
        }
    }
}
