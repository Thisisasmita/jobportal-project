package com.jobportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.JobSeekerDTO;
import com.jobportal.entity.Jobseeker;
import com.jobportal.repository.JobSeekerRepository;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeekerDTO createOrUpdate(JobSeekerDTO dto) {
        Jobseeker jobSeek = new Jobseeker();

        jobSeek.setId(dto.getId());
        jobSeek.setName(dto.getName());
        jobSeek.setEmail(dto.getEmail());
        jobSeek.setPhone(dto.getPhone());
        jobSeek.setUniversityName(dto.getUniversityName());
        jobSeek.setCourse(dto.getCourse());
        jobSeek.setPassingYear(dto.getPassingYear());
        jobSeek.setResumeURL(dto.getResumeURL());

        Jobseeker saved = jobSeekerRepository.save(jobSeek);

        JobSeekerDTO response = new JobSeekerDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setPhone(saved.getPhone());
        response.setUniversityName(saved.getUniversityName());
        response.setCourse(saved.getCourse());
        response.setPassingYear(saved.getPassingYear());
        response.setResumeURL(saved.getResumeURL());
        return response;
    }

    public JobSeekerDTO getJobSeekerByEmail(String email) {
        Optional<Jobseeker> jobSeeker = jobSeekerRepository.findByEmail(email);
        return jobSeeker.map(jobSeek -> {
            JobSeekerDTO dto = new JobSeekerDTO();
            dto.setId(jobSeek.getId());
            dto.setName(jobSeek.getName());
            dto.setEmail(jobSeek.getEmail());
            dto.setPhone(jobSeek.getPhone());
            dto.setUniversityName(jobSeek.getUniversityName());
            dto.setPassingYear(jobSeek.getPassingYear());
            dto.setCourse(jobSeek.getCourse());
            dto.setResumeURL(jobSeek.getResumeURL());
            return dto;
        }).orElse(null);
    }
}
