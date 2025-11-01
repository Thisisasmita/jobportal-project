package com.jobportal.dto;

import java.time.LocalDateTime;

import com.jobportal.enums.JobType;
import com.jobportal.enums.Status;

public class ApplicationDTO {

    private Long id;
    private String jobSeekerName;
    private String jobSeekerEmail;
    private String recruiterEmail;
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    private Status status;
    private LocalDateTime appliedAt;

    // ---------- Getters ----------
    public Long getId() {
        return id;
    }

    public String getJobSeekerName() {
        return jobSeekerName;
    }

    public String getJobSeekerEmail() {
        return jobSeekerEmail;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public JobType getJobType() {
        return jobType;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    // ---------- Setters ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setJobSeekerName(String jobSeekerName) {
        this.jobSeekerName = jobSeekerName;
    }

    public void setJobSeekerEmail(String jobSeekerEmail) {
        this.jobSeekerEmail = jobSeekerEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}

