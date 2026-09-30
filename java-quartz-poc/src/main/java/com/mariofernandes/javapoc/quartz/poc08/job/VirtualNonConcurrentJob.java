package com.mariofernandes.javapoc.quartz.poc08.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DisallowConcurrentExecution
public class VirtualNonConcurrentJob extends BaseConcurrencyJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(VirtualNonConcurrentJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        executeJob(context, "VirtualNonConcurrent");
    }
}
