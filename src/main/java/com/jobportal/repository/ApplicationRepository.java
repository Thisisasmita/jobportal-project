package com.jobportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.entity.Application;
import com.jobportal.enums.JobType;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobSeekerEmail(String jobSeekerEmail);

    List<Application> findByRecruiterEmail(String recruiterEmail);

    Optional<Application> findByJobSeekerEmailAndJobId(String jobSeekerEmail, Long jobId);

    List<Application> findByJobTitle(String jobTitle);

    List<Application> findByJobType(JobType jobType);
}
