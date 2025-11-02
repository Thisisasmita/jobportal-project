package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Recruiter;
import com.jobportal.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    // ✅ Create or update recruiter normally
    @PostMapping
    public ResponseEntity<Recruiter> saveRecruiter(@RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createOrRecruiterProfile(dto.getRecruiterEmail(), dto));
    }

    // ✅ Create or update recruiter using recruiterEmail in URL
    @PostMapping("/{recruiterEmail}")
    public ResponseEntity<Recruiter> saveOrUpdateRecruiter(
            @PathVariable String recruiterEmail,
            @RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createOrRecruiterProfile(recruiterEmail, dto));
    }
}
