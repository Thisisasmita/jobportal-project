package com.jobportal.dto;

public class JobPostStatusDTO {

    private long totalJobs;
    private long totalInternships;
    private long totalFullTimeJobs;
    private long totalPartTimeJobs;
    private long totalContractualJobs;
    private long totalFreelanceJobs;

    public JobPostStatusDTO() {}

    public JobPostStatusDTO(long totalJobs, long totalInternships, long totalFullTimeJobs,
                            long totalPartTimeJobs, long totalContractualJobs, long totalFreelanceJobs) {
        this.totalJobs = totalJobs;
        this.totalInternships = totalInternships;
        this.totalFullTimeJobs = totalFullTimeJobs;
        this.totalPartTimeJobs = totalPartTimeJobs;
        this.totalContractualJobs = totalContractualJobs;
        this.totalFreelanceJobs = totalFreelanceJobs;
    }

    public long getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public long getTotalInternships() {
        return totalInternships;
    }

    public void setTotalInternships(long totalInternships) {
        this.totalInternships = totalInternships;
    }

    public long getTotalFullTimeJobs() {
        return totalFullTimeJobs;
    }

    public void setTotalFullTimeJobs(long totalFullTimeJobs) {
        this.totalFullTimeJobs = totalFullTimeJobs;
    }

    public long getTotalPartTimeJobs() {
        return totalPartTimeJobs;
    }

    public void setTotalPartTimeJobs(long totalPartTimeJobs) {
        this.totalPartTimeJobs = totalPartTimeJobs;
    }

    public long getTotalContractualJobs() {
        return totalContractualJobs;
    }

    public void setTotalContractualJobs(long totalContractualJobs) {
        this.totalContractualJobs = totalContractualJobs;
    }

    public long getTotalFreelanceJobs() {
        return totalFreelanceJobs;
    }

    public void setTotalFreelanceJobs(long totalFreelanceJobs) {
        this.totalFreelanceJobs = totalFreelanceJobs;
    }
}
