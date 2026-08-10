package com.mariofernandes.javapoc.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HelloJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(HelloJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Hello World! {} - {} - {}",
                context.getJobDetail().getKey(), context.getJobDetail().getDescription(), LocalDateTime.now());
    }

}
