package com.mariofernandes.javapoc.quartz.poc09.service;

import com.mariofernandes.javapoc.quartz.poc09.job.ClusterJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Poc09SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(Poc09SchedulerService.class);
    private static final String POC09_GROUP = "poc09";

    private final Scheduler scheduler;

    public Poc09SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createJob() throws SchedulerException {
        var jobKey = JobKey.jobKey("ClusterJob", POC09_GROUP);
        var triggerKey = TriggerKey.triggerKey("ClusterTrigger", POC09_GROUP);

        if (scheduler.checkExists(jobKey)) {
            log.info("Job {} already exists", jobKey);
            return;
        }

        var jobDetail = JobBuilder.newJob(ClusterJob.class)
                .withIdentity(jobKey)
                .build();
        var triggerDetail = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .forJob(jobDetail)
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/10 * * * * ?")
                )
                .build();

        scheduler.scheduleJob(jobDetail, triggerDetail);
    }

    public String getSchedulerInstanceId() throws SchedulerException {
        return scheduler.getSchedulerInstanceId();
    }

    public String getSchedulerName() throws SchedulerException {
        return scheduler.getSchedulerName();
    }
}
