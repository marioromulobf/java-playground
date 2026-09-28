package com.mariofernandes.javapoc.quartz.rest;

import com.mariofernandes.javapoc.quartz.model.CronJobRequest;
import com.mariofernandes.javapoc.quartz.model.CreateJobRequest;
import com.mariofernandes.javapoc.quartz.model.CronJobResponse;
import com.mariofernandes.javapoc.quartz.service.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobRestController {

    private static final Logger log = LoggerFactory.getLogger(JobRestController.class);
    private final SchedulerService schedulerService;

    public JobRestController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping("/poc05/jobs")
    public ResponseEntity<Void> createJob(@RequestBody CreateJobRequest request) throws Exception {
        schedulerService.createJob(request);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/poc06/jobs/{name}")
    public ResponseEntity<CronJobResponse> getCronJob(@PathVariable(name = "name") String name) throws Exception {
        var cronJobResponse = schedulerService.getJob(name);

        return ResponseEntity.ok(cronJobResponse);
    }

    @PostMapping("/poc06/jobs")
    public ResponseEntity<Void> createCronJob(@RequestBody CronJobRequest request) throws Exception {
        schedulerService.createJob(request);

        return ResponseEntity.accepted().build();
    }

    @PutMapping("/poc06/jobs")
    public ResponseEntity<Void> updateCronJob(@RequestBody CronJobRequest request) throws Exception {
        schedulerService.updateJob(request);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/poc06/jobs/{name}")
    public ResponseEntity<Void> deleteJob(@PathVariable(name = "name") String name) throws Exception {
        schedulerService.deleteJob(name, "poc06");

        return ResponseEntity.noContent().build();
    }
}
