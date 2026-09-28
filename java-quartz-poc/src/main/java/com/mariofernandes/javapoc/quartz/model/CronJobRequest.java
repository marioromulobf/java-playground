package com.mariofernandes.javapoc.quartz.model;

public record CronJobRequest(
        String name,
        String cronExpression
) {
}
