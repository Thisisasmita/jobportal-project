package com.jobportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dto.ApplicationDTO;
import com.jobportal.entity.Application;
import com.jobportal.enums.JobType;
import com.jobportal.enums.Status;
import com.jobportal.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {

    private final ApplicationRepository appRepo;

    public ApplicationService(ApplicationRepository appRepo) {
        this.appRepo = appRepo;
    }

    public String apply(ApplicationDTO dto) {
        // Prevent duplicate application from same jobseeker to same job
        if (appRepo.findByJobSeekerEmailAndJobId(dto.getJobSeekerEmail(), dto.getJobId()).isPresent()) {
            throw new RuntimeException("You already applied for this job");
        }

        Application app = new Application();
        app.setJobId(dto.getJobId());
        app.setJobSeekerName(dto.getJobSeekerName());
        app.setJobSeekerEmail(dto.getJobSeekerEmail());
        app.setJobTitle(dto.getJobTitle());
        app.setJobType(dto.getJobType());
        app.setRecruiterEmail(dto.getRecruiterEmail());
        app.setStatus(dto.getStatus() == null ? Status.PENDING : dto.getStatus());
        app.setAppliedAt(dto.getAppliedAt() == null ? LocalDateTime.now() : dto.getAppliedAt());

        appRepo.save(app);
        return "You successfully applied to this job";
    }

    public List<ApplicationDTO> getByJobSeekerEmail(String jobSeekerEmail) {
        return appRepo.findByJobSeekerEmail(jobSeekerEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByRecruiterEmail(String recruiterEmail) {
        return appRepo.findByRecruiterEmail(recruiterEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobType(JobType jobType) {
        return appRepo.findByJobType(jobType)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobTitle(String jobTitle) {
        return appRepo.findByJobTitle(jobTitle)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void updateStatus(Long id, Status status) {
        Application app = appRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
        app.setStatus(status);
        appRepo.save(app);
    }

    private ApplicationDTO mapToDTO(Application app) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(app.getId());
        dto.setJobId(app.getJobId());
        dto.setJobSeekerName(app.getJobSeekerName());
        dto.setJobSeekerEmail(app.getJobSeekerEmail());
        dto.setRecruiterEmail(app.getRecruiterEmail());
        dto.setJobTitle(app.getJobTitle());
        dto.setJobType(app.getJobType());
        dto.setStatus(app.getStatus());
        dto.setAppliedAt(app.getAppliedAt());
        return dto;
    }
}
