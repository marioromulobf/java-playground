package com.mariofernandes.javapoc.quartz.service;

import com.mariofernandes.javapoc.quartz.jobs.DynamicJob;
import com.mariofernandes.javapoc.quartz.model.CreateJobRequest;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

@Service
public class SchedulerPoc05Service {

    private static final String POC05_GROUP = "poc05";
    private final Scheduler scheduler;

    public SchedulerPoc05Service(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createJob(CreateJobRequest request) throws SchedulerException {
        var jobKey = JobKey.jobKey(request.name() + "Job", POC05_GROUP);
        var triggerKey = TriggerKey.triggerKey(request.name() + "Trigger", POC05_GROUP);

        if (scheduler.checkExists(jobKey)) {
            throw new IllegalArgumentException("Job with name " + request.name() + " already exists.");
        }

        if  (scheduler.checkExists(triggerKey)) {
            throw new IllegalArgumentException("Trigger with name " + request.name() + " already exists.");
        }

        var jobDetail = JobBuilder.newJob(DynamicJob.class)
                .withIdentity(jobKey)
                .build();
        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobKey)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(request.intervalSeconds())
                        .withRepeatCount(request.repeatCount()))
                .build();

        scheduler.scheduleJob(jobDetail, triggerDetail);
    }
}
