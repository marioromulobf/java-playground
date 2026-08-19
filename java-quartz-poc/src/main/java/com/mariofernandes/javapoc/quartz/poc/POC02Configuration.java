package com.mariofernandes.javapoc.quartz.poc;

import com.mariofernandes.javapoc.quartz.jobs.SimpleJob;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class POC02Configuration {

    @Bean
    public JobDetail jobDetailPoc02() {
        // Define a JobDetail for the SimpleJob class, which will be used by the Quartz scheduler to execute the job.
        // The job is given an identity of "simpleJob" in the group "poc02".
        return JobBuilder.newJob(SimpleJob.class)
                .withIdentity("simpleJob", "poc02")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerPoc02A(@Qualifier("jobDetailPoc02") JobDetail jobDetailPoc02) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailPoc02)
                .withIdentity("trigger.A", "poc02")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .build();
    }

    @Bean
    public Trigger triggerPoc02B(@Qualifier("jobDetailPoc02") JobDetail jobDetailPoc02) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailPoc02)
                .withIdentity("trigger.B", "poc02")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withRepeatCount(0))
                .build();
    }

    @Bean
    public Trigger triggerPoc02C(@Qualifier("jobDetailPoc02") JobDetail jobDetailPoc02) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailPoc02)
                .withIdentity("trigger.C", "poc02")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(4))
                .build();
    }

    @Bean
    public Trigger triggerPoc02D(@Qualifier("jobDetailPoc02") JobDetail jobDetailPoc02) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailPoc02)
                .withIdentity("trigger.D", "poc02")
                .startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(1))
                .build();
    }

    @Bean
    public Trigger triggerPoc02E(@Qualifier("jobDetailPoc02") JobDetail jobDetailPoc02) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailPoc02)
                .withIdentity("trigger.E", "poc02")
                .startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(9))
                .endAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                .build();
    }
}
