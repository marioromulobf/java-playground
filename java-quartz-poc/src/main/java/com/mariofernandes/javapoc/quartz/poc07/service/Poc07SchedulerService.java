package com.mariofernandes.javapoc.quartz.poc07.service;

import com.mariofernandes.javapoc.quartz.poc07.dto.JobRequest;
import com.mariofernandes.javapoc.quartz.poc07.job.MisfireParametrizedJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Poc07SchedulerService {
    private static final String POC07_GROUP = "poc07";
    private final Scheduler scheduler;

    public Poc07SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createFireAndProceedJob(JobRequest request) throws SchedulerException {
        var name = request.name() + "FireAndProceed";
        var cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule(request.cronExpression())
                .withMisfireHandlingInstructionFireAndProceed();

        createJob(name, cronScheduleBuilder, request.dataMap());
    }

    public void createDoNothingJob(JobRequest request) throws SchedulerException {
        var name = request.name() + "DoNothing";
        var cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule(request.cronExpression())
                .withMisfireHandlingInstructionDoNothing();

        createJob(name, cronScheduleBuilder, request.dataMap());
    }

    private void createJob(String name, CronScheduleBuilder cronScheduleBuilder,
                           Map<String, String> dataMap) throws SchedulerException {
        var jobKey = JobKey.jobKey(name + "Job", POC07_GROUP);
        var triggerKey = TriggerKey.triggerKey(name + "Trigger", POC07_GROUP);

        validate(jobKey, triggerKey, name);

        var jobDataMap = new JobDataMap();
        if (dataMap != null) {
            jobDataMap.putAll(dataMap);
        }

        var jobDetail = JobBuilder.newJob(MisfireParametrizedJob.class)
                .withIdentity(jobKey)
                .usingJobData(jobDataMap)
                .build();

        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobKey)
                .startNow()
                .withSchedule(cronScheduleBuilder)
                .build();

        scheduler.scheduleJob(jobDetail, triggerDetail);
    }

    private void validate(JobKey jobKey, TriggerKey triggerKey, String name) throws SchedulerException {
        if (scheduler.checkExists(jobKey)) {
            throw new IllegalArgumentException("Job with name " + name + " already exists.");
        }

        if  (scheduler.checkExists(triggerKey)) {
            throw new IllegalArgumentException("Trigger with name " + name + " already exists.");
        }
    }
}
