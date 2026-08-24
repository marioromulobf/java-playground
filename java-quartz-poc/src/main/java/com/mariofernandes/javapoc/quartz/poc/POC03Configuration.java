package com.mariofernandes.javapoc.quartz.poc;

import com.mariofernandes.javapoc.quartz.jobs.CronJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class POC03Configuration {
    @Bean
    public JobDetail cronJobDetail() {
        // Define a JobDetail for the CronJob class, which will be used by the Quartz scheduler to execute the job.
        // The job is given an identity of "cronJob" in the group "poc03".
        return JobBuilder.newJob(CronJob.class)
                .withIdentity("cronJob", "poc03")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerPoc03A(@Qualifier("cronJobDetail") JobDetail cronJobDetail) {
        // Define a Trigger for the CronJob, which will execute the job every 10 seconds.
        // Scheduled: seconds, minutes, hours, day of month, month, day of week, year (optional)
        return TriggerBuilder.newTrigger()
                .forJob(cronJobDetail)
                .withIdentity("trigger.A.every10SecondsNoEnd", "poc03")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();
    }

    @Bean
    public Trigger triggerPoc03B(@Qualifier("cronJobDetail") JobDetail cronJobDetail) {
        // Define a Trigger for the CronJob, which will execute the job every weekday at 9 AM.
        // Scheduled: seconds, minutes, hours, day of month, month, day of week, year (optional)
        return TriggerBuilder.newTrigger()
                .forJob(cronJobDetail)
                .withIdentity("trigger.B.everyWeekdayAt9AM", "poc03")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 9 ? * MON-FRI"))
                .build();
    }

    @Bean
    public Trigger triggerPoc03C(@Qualifier("cronJobDetail") JobDetail cronJobDetail) {
        // Define a Trigger for the CronJob, which will execute the job every
        // 15 minutes between 8 AM and 5 PM on weekdays, in the "America/New_York" time zone.
        // Scheduled: seconds, minutes, hours, day of month, month, day of week, year (optional)
        return TriggerBuilder.newTrigger()
                .forJob(cronJobDetail)
                .withIdentity("trigger.C.every15MinutesBetween8And5OnWeekdays", "poc03")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/15 8-17 ? * MON-FRI")
                        .inTimeZone(TimeZone.getTimeZone("America/New_York")))
                .build();
    }
}
