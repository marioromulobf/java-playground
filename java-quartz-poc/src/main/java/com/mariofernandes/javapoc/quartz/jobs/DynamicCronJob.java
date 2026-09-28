package com.mariofernandes.javapoc.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class DynamicCronJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(DynamicCronJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // This method is called when the job is executed by the Quartz scheduler.
        var jobKey = context.getJobDetail().getKey();
        var triggerKey = context.getTrigger().getKey();
        // Get the previous and next fire time of the trigger associated with this job execution.
        var previousFireTime = context.getTrigger().getPreviousFireTime();
        var nextFireTime = context.getTrigger().getNextFireTime();

        log.info("P06.DynamicCronJob - {} - {} - {} - {} - {}", triggerKey, jobKey, previousFireTime, nextFireTime, LocalDateTime.now());
    }
}
