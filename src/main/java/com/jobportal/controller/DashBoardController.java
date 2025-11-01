package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ApplicationStatusDTO;
import com.jobportal.dto.CourseStatusDTO;
import com.jobportal.dto.JobPostStatusDTO;
import com.jobportal.dto.SubscriptionStatusDTO;
import com.jobportal.dto.UserStatusDTO;
import com.jobportal.service.DashBoardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping("/jobs")
    public ResponseEntity<JobPostStatusDTO> fetchJobs() {
        return ResponseEntity.ok(dashBoardService.fetchJobStatus());
    }

    @GetMapping("/applications")
    public ResponseEntity<ApplicationStatusDTO> fetchApplications() {
        return ResponseEntity.ok(dashBoardService.fetchApplicationStatus());
    }

    @GetMapping("/users")
    public ResponseEntity<UserStatusDTO> fetchUsers() {
        return ResponseEntity.ok(dashBoardService.fetchUsersStatus());
    }
    @GetMapping("/courses")
    public ResponseEntity<CourseStatusDTO> getCourseStatus() {
        return ResponseEntity.ok(dashBoardService.fetchCoursesStatus());
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<SubscriptionStatusDTO> getSubscriptionStatus() {
        return ResponseEntity.ok(dashBoardService.fetchSubscriptionStatus());
    }
}
