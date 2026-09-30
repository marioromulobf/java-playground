package com.mariofernandes.javapoc.quartz.poc08.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlatformConcurrentJob extends BaseConcurrencyJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(PlatformConcurrentJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        executeJob(context, "PlatformConcurrent");
    }
}
