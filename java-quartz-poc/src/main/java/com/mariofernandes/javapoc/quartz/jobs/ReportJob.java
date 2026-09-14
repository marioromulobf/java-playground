package com.mariofernandes.javapoc.quartz.jobs;

import com.mariofernandes.javapoc.quartz.model.ConfigurationDTO;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(ReportJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // getMergedJobDataMap() returns a merged view of the JobDataMap from the JobDetail and the Trigger.
        var dataMap = context.getMergedJobDataMap();
        var application = dataMap.getString("application");
        var environment = dataMap.getString("environment");
        var executionType = dataMap.getString("executionType");

        log.info("P04.ReportJob - {} - {} - {} - {} - {}",
                application, environment, executionType, context.getScheduledFireTime(),
                context.getFireTime());

        if (dataMap.containsKey("maxRetries") && dataMap.containsKey("timeout") && dataMap.containsKey("enabled") && dataMap.containsKey("configuration")) {
            var maxRetries = dataMap.getInt("maxRetries");
            var timeout = dataMap.getLong("timeout");
            var enabled = dataMap.getBoolean("enabled");
            var configuration = (ConfigurationDTO) dataMap.get("configuration");
            log.info("P04.ReportJob - Max Retries: {}, Timeout: {}, Enabled: {}, Configuration: {}", maxRetries, timeout, enabled, configuration);
        }
    }

}
