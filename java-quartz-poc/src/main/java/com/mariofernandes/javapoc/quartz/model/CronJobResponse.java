package com.mariofernandes.javapoc.quartz.model;

public record CronJobResponse(
        String name,
        String group,
        String triggerState,
        String cronExpression,
        String previousFireTime,
        String nextFireTime
) {
}
