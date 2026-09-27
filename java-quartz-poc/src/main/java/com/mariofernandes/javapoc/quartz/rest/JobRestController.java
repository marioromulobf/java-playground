package com.mariofernandes.javapoc.quartz.rest;

import com.mariofernandes.javapoc.quartz.model.CreateJobRequest;
import com.mariofernandes.javapoc.quartz.service.SchedulerPoc05Service;
import org.quartz.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poc05/jobs")
public class JobRestController {
    private final SchedulerPoc05Service schedulerPoc05Service;

    public JobRestController(SchedulerPoc05Service schedulerPoc05Service) {
        this.schedulerPoc05Service = schedulerPoc05Service;
    }

    @PostMapping
    public ResponseEntity<Void> createJob(@RequestBody CreateJobRequest request) throws Exception {
        schedulerPoc05Service.createJob(request);

        return ResponseEntity.accepted().build();
    }
}
