package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.JobPostDTO;
import com.jobportal.service.JobPostService;

@RestController
@RequestMapping("/api/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    // ---------- Create Job ----------
    @PostMapping("/create")
    public ResponseEntity<JobPostDTO> createJob(@RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(jobPostService.createJob(dto));
    }

    // ---------- Get Jobs by Company Name ----------
    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<JobPostDTO>> getJobByCompanyName(@PathVariable String companyName) {
        return ResponseEntity.ok(jobPostService.findJobByCompanyName(companyName));
    }

    // ---------- Get Jobs by Recruiter Email ----------
    @GetMapping("/recruiter/{recruiterEmail}")
    public ResponseEntity<List<JobPostDTO>> getJobByRecruiterEmail(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(jobPostService.findJobByRecruiterEmail(recruiterEmail));
    }

    // ---------- Get Jobs by Job Title ----------
    @GetMapping("/title/{jobTitle}")
    public ResponseEntity<List<JobPostDTO>> getJobByJobTitle(@PathVariable String jobTitle) {
        return ResponseEntity.ok(jobPostService.findJobByJobTitle(jobTitle));
    }
}
