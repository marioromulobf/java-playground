package com.mariofernandes.javapoc.quartz.poc;

import com.mariofernandes.javapoc.quartz.jobs.ReportJob;
import com.mariofernandes.javapoc.quartz.model.ConfigurationDTO;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class POC04Configuration {
    @Bean
    public JobDetail reportJobDetail() {
        // Define a JobDetail for the ReportJob class, which will be used by the Quartz scheduler to execute the job.
        // The job is given an identity of "reportJob" in the group "poc04".
        return JobBuilder.newJob(ReportJob.class)
                .withIdentity("reportJob", "poc04")
                .usingJobData("application", "java-quartz-poc")
                .usingJobData("environment", "dev")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerPOC04A(@Qualifier("reportJobDetail") JobDetail reportJobDetail) {
        // Define a Trigger for the ReportJob, which will execute the job every 10 seconds.
        return TriggerBuilder.newTrigger()
                .forJob(reportJobDetail)
                .withIdentity("trigger.A.morning", "poc04")
                .usingJobData("executionType", "MORNING")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever()
                )
                .build();
    }

    @Bean
    public Trigger triggerPOC04B(@Qualifier("reportJobDetail") JobDetail reportJobDetail) {
        // Define a Trigger for the ReportJob, which will execute the job every 15 seconds.
        return TriggerBuilder.newTrigger()
                .forJob(reportJobDetail)
                .withIdentity("trigger.B.night", "poc04")
                .usingJobData("executionType", "NIGHT")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(15)
                        .repeatForever()
                )
                .build();
    }

    @Bean
    public Trigger triggerPOC04C(@Qualifier("reportJobDetail") JobDetail reportJobDetail) {
        // Define a Trigger for the ReportJob, which will execute the job every 30 seconds.
        return TriggerBuilder.newTrigger()
                .forJob(reportJobDetail)
                .withIdentity("trigger.C.afternoon", "poc04")
                .usingJobData("executionType", "AFTERNOON")
                .usingJobData("environment", "prod")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(30)
                        .repeatForever()
                )
                .build();
    }

    @Bean
    public Trigger triggerPOC04D(@Qualifier("reportJobDetail") JobDetail reportJobDetail) {
        // Define a Trigger for the ReportJob, which will execute the job every 12 seconds.
        var dataMap = new JobDataMap();
        dataMap.put("executionType", "EVERY_12_SECONDS");
        dataMap.put("maxRetries", 3);
        dataMap.put("timeout", 5000L);
        dataMap.put("enabled", true);
        dataMap.put("configuration", new ConfigurationDTO("configName", 666));

        return TriggerBuilder.newTrigger()
                .forJob(reportJobDetail)
                .withIdentity("trigger.D.every12seconds", "poc04")
                .usingJobData(dataMap)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(12)
                        .repeatForever()
                )
                .build();
    }
}
