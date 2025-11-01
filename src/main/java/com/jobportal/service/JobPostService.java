package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.JobPostDTO;
import com.jobportal.entity.JobPost;
import com.jobportal.repository.JobPostRepository;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    // ---------- Create Job ----------
    public JobPostDTO createJob(JobPostDTO dto) {
        JobPost job = new JobPost();

        job.setCompanyName(dto.getCompanyName());
        job.setRecruiterEmail(dto.getRecruiterEmail());
        job.setRecruiterId(dto.getRecruiterId());
        job.setJobTitle(dto.getJobTitle());
        job.setJobCategory(dto.getJobCategory());
        job.setJobDescription(dto.getJobDescription());
        job.setJobType(dto.getJobType());
        job.setJobLocation(dto.getJobLocation());
        job.setRemote(dto.isRemote());
        job.setPostedDate(dto.getPostedDate());
        job.setActive(dto.isActive());

        JobPost saved = jobPostRepository.save(job);
        return mapToDTO(saved);
    }

    // ---------- Find by Company Name ----------
    public List<JobPostDTO> findJobByCompanyName(String companyName) {
        return jobPostRepository.findByCompanyName(companyName)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------- Find by Recruiter Email ----------
    public List<JobPostDTO> findJobByRecruiterEmail(String recruiterEmail) {
        return jobPostRepository.findByRecruiterEmail(recruiterEmail)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------- Find by Job Title ----------
    public List<JobPostDTO> findJobByJobTitle(String jobTitle) {
        return jobPostRepository.findByJobTitle(jobTitle)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------- Mapper: Entity → DTO ----------
    private JobPostDTO mapToDTO(JobPost post) {
        JobPostDTO dto = new JobPostDTO();
        dto.setId(post.getId());
        dto.setRecruiterId(post.getRecruiterId());
        dto.setRecruiterEmail(post.getRecruiterEmail());
        dto.setCompanyName(post.getCompanyName());
        dto.setJobTitle(post.getJobTitle());
        dto.setJobCategory(post.getJobCategory());
        dto.setJobDescription(post.getJobDescription());
        dto.setJobType(post.getJobType());
        dto.setJobLocation(post.getJobLocation());
        dto.setPostedDate(post.getPostedDate());
        dto.setRemote(post.isRemote());
        dto.setActive(post.isActive());
        return dto;
    }
}