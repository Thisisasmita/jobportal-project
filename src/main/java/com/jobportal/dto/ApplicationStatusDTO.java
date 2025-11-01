package com.jobportal.dto;

public class ApplicationStatusDTO {

    private long totalApplications;
    private long totalShortlisted;
    private long totalRejected;
    private long totalPending;

    public ApplicationStatusDTO() {}

    public ApplicationStatusDTO(long totalApplications, long totalShortlisted, long totalRejected, long totalPending) {
        this.totalApplications = totalApplications;
        this.totalShortlisted = totalShortlisted;
        this.totalRejected = totalRejected;
        this.totalPending = totalPending;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }

    public long getTotalShortlisted() {
        return totalShortlisted;
    }

    public void setTotalShortlisted(long totalShortlisted) {
        this.totalShortlisted = totalShortlisted;
    }

    public long getTotalRejected() {
        return totalRejected;
    }

    public void setTotalRejected(long totalRejected) {
        this.totalRejected = totalRejected;
    }

    public long getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(long totalPending) {
        this.totalPending = totalPending;
    }
}
