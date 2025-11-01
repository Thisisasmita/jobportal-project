package com.jobportal.entity;

import java.time.LocalDateTime;

import com.jobportal.enums.JobType;
import com.jobportal.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobSeekerName;

    @Column(nullable = false)
    private String jobSeekerEmail;

    private Long jobId;

    private String jobTitle;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Column(nullable = false)
    private String recruiterEmail;

    @Enumerated(EnumType.STRING)
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

    public Long getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public JobType getJobType() {
        return jobType;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
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

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}
