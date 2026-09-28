package com.mariofernandes.javapoc.quartz.poc07.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class MisfireParametrizedJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(MisfireParametrizedJob.class);
    private static final Set<String> validKeys = Set.of("environment", "reportType", "requestedBy");

    @Override
    public void execute(JobExecutionContext context) {
        var jobKey = context.getJobDetail().getKey();
        var triggerKey = context.getTrigger().getKey();
        var previousFireTime = context.getTrigger().getPreviousFireTime();
        var nextFireTime = context.getTrigger().getNextFireTime();

        var dataMap = context.getMergedJobDataMap();
        var values = dataMap.entrySet().stream()
                .filter(entry -> validKeys.contains(entry.getKey()))
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .toList();

        log.info("P07.MisfireParametrizedJob - {} - {} - {} - {} - {} - {}", triggerKey, jobKey, values, previousFireTime, nextFireTime, System.currentTimeMillis());
    }
}
