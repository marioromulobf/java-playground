package com.mariofernandes.javapoc.quartz.poc09.rest;

import com.mariofernandes.javapoc.quartz.poc09.service.Poc09SchedulerService;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/poc09")
public class Poc09RestController {
    private final Poc09SchedulerService schedulerService;

    public Poc09RestController(Poc09SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping("/jobs")
    public ResponseEntity<Void> createJob() throws SchedulerException {
        schedulerService.createJob();

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/scheduler")
    public ResponseEntity<Map<String, String>> schedulerInfo() throws SchedulerException {
        return ResponseEntity.ok(Map.of(
                "name", schedulerService.getSchedulerName(),
                "instanceId", schedulerService.getSchedulerInstanceId()
        ));
    }
}
