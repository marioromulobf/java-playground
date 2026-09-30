package com.mariofernandes.javapoc.quartz.poc05.rest;

import com.mariofernandes.javapoc.quartz.model.CreateJobRequest;
import com.mariofernandes.javapoc.quartz.poc05.service.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poc05/jobs")
public class JobPoc05RestController {

    private static final Logger log = LoggerFactory.getLogger(JobPoc05RestController.class);
    private final SchedulerService schedulerService;

    public JobPoc05RestController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping
    public ResponseEntity<Void> createJob(@RequestBody CreateJobRequest request) throws Exception {
        schedulerService.createJob(request);

        return ResponseEntity.accepted().build();
    }
}
