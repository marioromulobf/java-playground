package com.mariofernandes.javapoc.quartz.jobs;

import org.quartz.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(CronJob.class);

    @Override
    public void execute(org.quartz.JobExecutionContext context) throws org.quartz.JobExecutionException {
        // This method is called when the job is executed by the Quartz scheduler.
        var triggerKey = context.getTrigger().getKey();
        var jobKey = context.getJobDetail().getKey();
        // Get the scheduled fire time and actual fire time of the job execution.
        var scheduledFireTime = context.getScheduledFireTime();
        var actualFireTime = context.getFireTime();

        log.info("P03.CronJob - {} - {} - {} - {} - {}", triggerKey, jobKey, scheduledFireTime, actualFireTime, java.time.LocalDateTime.now());
    }
}
