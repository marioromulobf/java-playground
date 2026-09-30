package com.mariofernandes.javapoc.quartz.poc08.service;

import com.mariofernandes.javapoc.quartz.poc08.job.PlatformConcurrentJob;
import com.mariofernandes.javapoc.quartz.poc08.job.PlatformNonConcurrentJob;
import com.mariofernandes.javapoc.quartz.poc08.job.VirtualConcurrentJob;
import com.mariofernandes.javapoc.quartz.poc08.job.VirtualNonConcurrentJob;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Poc08SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(Poc08SchedulerService.class);
    private static final String POC08_GROUP = "Poc08JobGroup";
    private final Scheduler scheduler;

    public Poc08SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createPlatformConcurrentJob() throws SchedulerException {
        createJob("PlatformConcurrent", PlatformConcurrentJob.class);
    }

    public void createPlatformNonConcurrentJob() throws SchedulerException {
        createJob("PlatformNonConcurrent", PlatformNonConcurrentJob.class);
    }

    public void createVirtualConcurrentJob() throws SchedulerException {
        createJob("VirtualConcurrent", VirtualConcurrentJob.class);
    }

    public void createVirtualNonConcurrentJob() throws SchedulerException {
        createJob("VirtualNonConcurrent", VirtualNonConcurrentJob.class);
    }

    private void createJob(String name, Class<? extends Job> jobClass) throws SchedulerException {
        var jobKey = JobKey.jobKey(name + "Job", POC08_GROUP);
        var triggerKey = TriggerKey.triggerKey(name + "Trigger", POC08_GROUP);

        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }

        var jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobKey)
                .build();
        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobKey)
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                )
                .build();

        scheduler.scheduleJob(jobDetail, triggerDetail);
    }

    public void deleteJob(String name) throws SchedulerException {
        var jobKey = JobKey.jobKey(name + "Job", POC08_GROUP);

        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }
    }

    public void deleteAllJobs() throws SchedulerException {
        scheduler.getJobKeys(GroupMatcher.jobGroupEquals(POC08_GROUP))
                .forEach(jobKey -> {
                    try {
                        scheduler.deleteJob(jobKey);
                    } catch (SchedulerException e) {
                        log.error("Error deleting job: {}", jobKey, e);
                        throw new RuntimeException(e);
                    }
                });
    }
}
