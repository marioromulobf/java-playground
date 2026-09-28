package com.mariofernandes.javapoc.quartz.poc07.dto;

import java.util.Map;

public record JobRequest(
        String name,
        String cronExpression,
        Map<String, String> dataMap
) { }
