package com.mariofernandes.javapoc.quartz.model;

public record CreateJobRequest(
        String name,
        int intervalSeconds,
        int repeatCount
) { }
