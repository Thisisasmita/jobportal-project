package com.jobportal.service;

import org.springframework.stereotype.Service;

import com.jobportal.dto.ApplicationStatusDTO;
import com.jobportal.dto.CourseStatusDTO;
import com.jobportal.dto.JobPostStatusDTO;
import com.jobportal.dto.SubscriptionStatusDTO;
import com.jobportal.dto.UserStatusDTO;

@Service
public class DashBoardService {

    public JobPostStatusDTO fetchJobStatus() {
        JobPostStatusDTO jobs = new JobPostStatusDTO();
        jobs.setTotalJobs(120);
        jobs.setTotalInternships(70);
        jobs.setTotalFullTimeJobs(50);
        jobs.setTotalPartTimeJobs(70);
        jobs.setTotalContractualJobs(50);
        jobs.setTotalFreelanceJobs(50);
        return jobs;
    }

    public ApplicationStatusDTO fetchApplicationStatus() {
        ApplicationStatusDTO applicant = new ApplicationStatusDTO();
        applicant.setTotalApplications(500);
        applicant.setTotalShortlisted(100);
        applicant.setTotalRejected(150);
        applicant.setTotalPending(250);
        return applicant;
    }

    public UserStatusDTO fetchUsersStatus() {
        UserStatusDTO users = new UserStatusDTO();
        users.setTotalJobseekers(10000);
        users.setTotalRecruiters(500);
        users.setTotalBlockUsers(1000);
        return users;
    }

    public CourseStatusDTO fetchCoursesStatus() {
        return CourseStatusDTO.builder()
                .totalCourses(50)
                .activeCourses(30)
                .inactiveCourses(20)
                .build();
    }

    public SubscriptionStatusDTO fetchSubscriptionStatus() {
        int totalPayments = 250;
        int paidUsers = 150;
        double totalRevenue = 10000;
        int activePlans = 100;

        double avgRevenuePerUser = totalRevenue / paidUsers;

        return SubscriptionStatusDTO.builder()
                .totalPayments(totalPayments)
                .paidUsers(paidUsers)
                .totalRevenue(totalRevenue)
                .averageRevenuePerUser(avgRevenuePerUser)
                .activePlans(activePlans)
                .build();
    }
}
