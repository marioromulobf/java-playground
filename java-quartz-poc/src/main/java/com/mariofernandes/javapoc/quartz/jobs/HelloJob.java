package com.mariofernandes.javapoc.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class HelloJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // This method is called when the job is executed by the Quartz scheduler.
        log.info("Hello World! {} - {} - {}",
                context.getTrigger().getKey(), context.getJobDetail().getKey(), LocalDateTime.now());
    }

}
