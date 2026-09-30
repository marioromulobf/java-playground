package com.mariofernandes.javapoc.quartz.poc08.rest;

import com.mariofernandes.javapoc.quartz.poc08.service.Poc08SchedulerService;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poc08/jobs")
public class Poc08RestController {
    private final Poc08SchedulerService schedulerService;

    public Poc08RestController(Poc08SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping("/platform-concurrent")
    public ResponseEntity<Void> createPlatformConcurrentJob() throws SchedulerException {
        schedulerService.createPlatformConcurrentJob();

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/platform-non-concurrent")
    public ResponseEntity<Void> createPlatformNonConcurrentJob() throws SchedulerException {
        schedulerService.createPlatformNonConcurrentJob();

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/virtual-concurrent")
    public ResponseEntity<Void> createVirtualConcurrentJob() throws SchedulerException {
        schedulerService.createVirtualConcurrentJob();

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/virtual-non-concurrent")
    public ResponseEntity<Void> createVirtualNonConcurrentJob() throws SchedulerException {
        schedulerService.createVirtualNonConcurrentJob();

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteJob(@PathVariable(name = "name") String name) throws SchedulerException {
        schedulerService.deleteJob(name);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllJobs() throws SchedulerException {
        schedulerService.deleteAllJobs();

        return ResponseEntity.noContent().build();
    }
}
