package com.mariofernandes.javapoc.quartz.poc07.rest;

import com.mariofernandes.javapoc.quartz.poc07.dto.JobRequest;
import com.mariofernandes.javapoc.quartz.poc07.service.Poc07SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poc07/misfire")
public class MisfireParametrizedRestController {
    private final Poc07SchedulerService poc07SchedulerService;

    public MisfireParametrizedRestController(Poc07SchedulerService poc07SchedulerService) {
        this.poc07SchedulerService = poc07SchedulerService;
    }

    @PostMapping("/fire-and-proceed")
    public ResponseEntity<Void> createFireAndProceedJob(@RequestBody JobRequest request) throws Exception {
        poc07SchedulerService.createFireAndProceedJob(request);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/do-nothing")
    public ResponseEntity<Void> createDoNothingJob(@RequestBody JobRequest request) throws Exception {
        poc07SchedulerService.createDoNothingJob(request);

        return ResponseEntity.accepted().build();
    }

}
