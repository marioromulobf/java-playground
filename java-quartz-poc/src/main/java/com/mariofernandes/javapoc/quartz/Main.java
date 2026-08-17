package com.mariofernandes.javapoc.quartz;

import com.mariofernandes.javapoc.quartz.jobs.HelloJob;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public void run() throws SchedulerException {
        // first example of scheduling a job with Quartz
        log.info("------- Initializing ----------------------");
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        log.info("------- Initialization Complete -----------");

        Date runTime = DateBuilder.evenMinuteDate(new Date());

        log.info("------- Scheduling Job  -------------------");

        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(runTime)
                .build();

        scheduler.scheduleJob(job, trigger);
        log.info("{} will run at: {}", job.getKey(), runTime);
        scheduler.start();

        log.info("------- Started Scheduler -----------------");

        log.info("------- Waiting 65 seconds... -------------");
        try {
            Thread.sleep(65L * 1000L);
        }  catch (Exception e) {
            log.error("Error occurred while waiting", e);
        }

        log.info("------- Shutting Down ---------------------");
        scheduler.shutdown(true);
        log.info("------- Shutdown Complete -----------------");
    }

    static void main(String[] args) throws SchedulerException {
        System.out.println("=== Java - Quartz POC ===\n");
        SpringApplication.run(Main.class, args);
    }
}
