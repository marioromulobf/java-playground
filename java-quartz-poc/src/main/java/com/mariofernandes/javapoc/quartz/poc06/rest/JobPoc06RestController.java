package com.mariofernandes.javapoc.quartz.poc06.rest;

import com.mariofernandes.javapoc.quartz.model.CronJobRequest;
import com.mariofernandes.javapoc.quartz.model.CronJobResponse;
import com.mariofernandes.javapoc.quartz.poc05.service.SchedulerService;
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
@RequestMapping("/api/poc06/jobs")
public class JobPoc06RestController {

    private static final Logger log = LoggerFactory.getLogger(JobPoc06RestController.class);
    private final SchedulerService schedulerService;

    public JobPoc06RestController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<CronJobResponse> getCronJob(@PathVariable(name = "name") String name) throws Exception {
        var cronJobResponse = schedulerService.getJob(name);

        return ResponseEntity.ok(cronJobResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createCronJob(@RequestBody CronJobRequest request) throws Exception {
        schedulerService.createJob(request);

        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCronJob(@RequestBody CronJobRequest request) throws Exception {
        schedulerService.updateJob(request);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteJob(@PathVariable(name = "name") String name) throws Exception {
        schedulerService.deleteJob(name, "poc06");

        return ResponseEntity.noContent().build();
    }
}
