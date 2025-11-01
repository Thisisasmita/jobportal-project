package com.jobportal.dto;

public class UserStatusDTO {

    private long totalJobseekers;
    private long totalRecruiters;
    private long totalBlockUsers;

    public UserStatusDTO() {}

    public UserStatusDTO(long totalJobseekers, long totalRecruiters, long totalBlockUsers) {
        this.totalJobseekers = totalJobseekers;
        this.totalRecruiters = totalRecruiters;
        this.totalBlockUsers = totalBlockUsers;
    }

    public long getTotalJobseekers() {
        return totalJobseekers;
    }

    public void setTotalJobseekers(long totalJobseekers) {
        this.totalJobseekers = totalJobseekers;
    }

    public long getTotalRecruiters() {
        return totalRecruiters;
    }

    public void setTotalRecruiters(long totalRecruiters) {
        this.totalRecruiters = totalRecruiters;
    }

    public long getTotalBlockUsers() {
        return totalBlockUsers;
    }

    public void setTotalBlockUsers(long totalBlockUsers) {
        this.totalBlockUsers = totalBlockUsers;
    }
}
