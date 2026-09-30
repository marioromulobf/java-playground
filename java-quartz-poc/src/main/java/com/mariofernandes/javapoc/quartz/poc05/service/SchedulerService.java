package com.mariofernandes.javapoc.quartz.poc05.service;

import com.mariofernandes.javapoc.quartz.jobs.DynamicCronJob;
import com.mariofernandes.javapoc.quartz.jobs.DynamicJob;
import com.mariofernandes.javapoc.quartz.model.CronJobRequest;
import com.mariofernandes.javapoc.quartz.model.CreateJobRequest;
import com.mariofernandes.javapoc.quartz.model.CronJobResponse;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);
    private static final String POC05_GROUP = "poc05";
    private static final String POC06_GROUP = "poc06";
    private final Scheduler scheduler;

    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createJob(CreateJobRequest request) throws SchedulerException {
        var jobKey = JobKey.jobKey(request.name() + "Job", POC05_GROUP);
        var triggerKey = TriggerKey.triggerKey(request.name() + "Trigger", POC05_GROUP);
        validate(jobKey, triggerKey, request.name());

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

    public void createJob(CronJobRequest request) throws SchedulerException {
        var jobKey = JobKey.jobKey(request.name() + "Job", POC06_GROUP);
        var triggerKey = TriggerKey.triggerKey(request.name() + "Trigger", POC06_GROUP);
        validate(jobKey, triggerKey, request.name());

        var jobDetail = JobBuilder.newJob(DynamicCronJob.class)
                .withIdentity(jobKey)
                .build();
        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobKey)
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(request.cronExpression())
                )
                .build();

        scheduler.scheduleJob(jobDetail, triggerDetail);
    }

    public void updateJob(CronJobRequest request) throws SchedulerException {
        var jobKey = JobKey.jobKey(request.name() + "Job", POC06_GROUP);
        var triggerKey = TriggerKey.triggerKey(request.name() + "Trigger", POC06_GROUP);

        if (!scheduler.checkExists(jobKey)) {
            throw new IllegalArgumentException("Job with name " + request.name() + " does not exist.");
        }

        if (!scheduler.checkExists(triggerKey)) {
            throw new IllegalArgumentException("Trigger with name " + request.name() + " does not exist.");
        }

        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobKey)
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(request.cronExpression())
                )
                .build();

        scheduler.rescheduleJob(triggerKey, triggerDetail);
    }

    private void validate(JobKey jobKey, TriggerKey triggerKey, String name) throws SchedulerException {
        if (scheduler.checkExists(jobKey)) {
            throw new IllegalArgumentException("Job with name " + name + " already exists.");
        }

        if  (scheduler.checkExists(triggerKey)) {
            throw new IllegalArgumentException("Trigger with name " + name + " already exists.");
        }
    }

    public void deleteJob(String name, String group) {
        var jobKey = JobKey.jobKey(name + "Job", group);
        var triggerKey = TriggerKey.triggerKey(name + "Trigger", group);

        try {
            if (!scheduler.checkExists(jobKey)) {
                throw new IllegalArgumentException("Job with name " + name + " does not exist.");
            }

            if (!scheduler.checkExists(triggerKey)) {
                throw new IllegalArgumentException("Trigger with name " + name + " does not exist.");
            }

            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException("Failed to delete job with name " + name, e);
        }
    }

    public CronJobResponse getJob(String name) {
        var jobKey = JobKey.jobKey(name + "Job", POC06_GROUP);
        var triggerKey = TriggerKey.triggerKey(name + "Trigger", POC06_GROUP);

        try {
            if (!scheduler.checkExists(jobKey)) {
                throw new IllegalArgumentException("Job with name " + name + " does not exist.");
            }

            if (!scheduler.checkExists(triggerKey)) {
                throw new IllegalArgumentException("Trigger with name " + name + " does not exist.");
            }

            var jobDetail = scheduler.getJobDetail(jobKey);
            var triggerDetail = scheduler.getTrigger(triggerKey);

            return new CronJobResponse(
                    jobDetail.getKey().getName(),
                    jobDetail.getKey().getGroup(),
                    scheduler.getTriggerState(triggerKey).name(),
                    ((CronTrigger) triggerDetail).getCronExpression(),
                    triggerDetail.getPreviousFireTime() != null ? triggerDetail.getPreviousFireTime().toString() : null,
                    triggerDetail.getNextFireTime() != null ? triggerDetail.getNextFireTime().toString() : null
            );
        } catch (SchedulerException e) {
            throw new RuntimeException("Failed to get job with name " + name, e);
        }
    }
}
