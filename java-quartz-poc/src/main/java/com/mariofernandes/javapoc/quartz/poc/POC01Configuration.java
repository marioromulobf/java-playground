package com.mariofernandes.javapoc.quartz.poc;

import com.mariofernandes.javapoc.quartz.jobs.HelloJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class POC01Configuration {

    @Bean
    public JobDetail helloJobDetail() {
        // Define a JobDetail for the HelloJob class, which will be used by the Quartz scheduler to execute the job.
        // The job is given an identity of "helloJob" in the group "poc01" and is marked as durable,
        // meaning it will persist even if there are no triggers associated with it.
        return JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob", "poc01")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger helloTrigger() {
        // Define a Trigger that will fire the HelloJob at a regular interval.
        // The trigger is associated with the helloJobDetail defined above,
        // has an identity of "helloTrigger" in the group "poc01", and is set to start immediately.
        // The schedule is defined to repeat every 5 seconds indefinitely.
        return TriggerBuilder.newTrigger()
                .forJob(helloJobDetail())
                .withIdentity("helloTrigger", "poc01")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();
    }
}
