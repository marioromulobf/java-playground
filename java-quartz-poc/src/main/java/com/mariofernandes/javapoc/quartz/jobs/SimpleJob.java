package com.mariofernandes.javapoc.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class SimpleJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(SimpleJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // This method is called when the job is executed by the Quartz scheduler.
        var triggerKey = context.getTrigger().getKey();
        var jobKey = context.getJobDetail().getKey();
        var description = context.getJobDetail().getDescription();

        log.info("ExecuteSimpleJob - {} - {} - {} - {}", triggerKey, jobKey, description, LocalDateTime.now());
    }

}
