package com.jobportal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ApplicationDTO;
import com.jobportal.enums.JobType;
import com.jobportal.enums.Status;
import com.jobportal.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService appService;

    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody ApplicationDTO dto) {
        String msg = appService.apply(dto);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/jobseeker")
    public ResponseEntity<List<ApplicationDTO>> getJobSeekerApplications(@RequestParam String jobSeekerEmail) {
        return ResponseEntity.ok(appService.getByJobSeekerEmail(jobSeekerEmail));
    }

    @GetMapping("/recruiter")
    public ResponseEntity<List<ApplicationDTO>> getRecruiterApplications(@RequestParam String recruiterEmail) {
        return ResponseEntity.ok(appService.getByRecruiterEmail(recruiterEmail));
    }

    @GetMapping("/jobType")
    public ResponseEntity<List<ApplicationDTO>> getByJobType(@RequestParam JobType jobType) {
        return ResponseEntity.ok(appService.getByJobType(jobType));
    }

    @GetMapping("/jobTitle")
    public ResponseEntity<List<ApplicationDTO>> getByJobTitle(@RequestParam String jobTitle) {
        return ResponseEntity.ok(appService.getByJobTitle(jobTitle));
    }

    @PostMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestParam Long id, @RequestParam Status status) {
        appService.updateStatus(id, status);
        return ResponseEntity.ok("Status updated");
    }
}
