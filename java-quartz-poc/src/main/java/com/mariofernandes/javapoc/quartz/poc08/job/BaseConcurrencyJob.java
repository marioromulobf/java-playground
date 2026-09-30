package com.mariofernandes.javapoc.quartz.poc08.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public abstract class BaseConcurrencyJob {

    private static final Logger log = LoggerFactory.getLogger(BaseConcurrencyJob.class);
    protected void executeJob(JobExecutionContext context, String type) throws JobExecutionException {
        var thread = Thread.currentThread();
        var startTime = LocalDateTime.now();
        var jobKey = context.getJobDetail().getKey();
        var triggerKey = context.getTrigger().getKey();

        try {
            log.info("Executing {} job with key: {} and trigger: {} on thread: {} at {}", type, jobKey, triggerKey, thread.getName(), startTime);
            // Simulate job processing time
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            log.error("{} Job execution interrupted for job key: {}", type, jobKey, e);
            Thread.currentThread().interrupt();
        } finally {
            var endTime = LocalDateTime.now();
            log.info("Finished executing {} job with key: {} and trigger: {} on thread: {} at {}", type, jobKey, triggerKey, thread.getName(), endTime);
        }
    }
}
