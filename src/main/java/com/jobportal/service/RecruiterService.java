package com.jobportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Recruiter;
import com.jobportal.repository.RecruiterRepository;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public Recruiter createOrRecruiterProfile(String recruiterEmail,RecruiterDTO dto){
        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail).orElse(new Recruiter());
        recruiter.setRecruiterEmail(dto.getRecruiterEmail());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setRecruiterPhone(dto.getRecruiterPhone());
        recruiter.setCompanyWebsite(dto.getCompanyWebsite());

        return recruiterRepository.save(recruiter);
    }


    public Recruiter getRecruiterByCompanyName(String companyName) {
        return recruiterRepository.findByCompanyName(companyName).orElseThrow(()->new RuntimeException("Recruiter not found"));
    }

    /**
     * Update recruiter details
     */
    public Recruiter updateRecruiter(Long id, RecruiterDTO dto) {
        Optional<Recruiter> existingRecruiter = recruiterRepository.findById(id);
        if (existingRecruiter.isPresent()) {
            Recruiter recruiter = existingRecruiter.get();
            recruiter.setRecruiterEmail(dto.getRecruiterEmail());
            recruiter.setCompanyName(dto.getCompanyName());
            recruiter.setRecruiterPhone(dto.getRecruiterPhone());
            recruiter.setCompanyWebsite(dto.getCompanyWebsite());
            return recruiterRepository.save(recruiter);
        } else {
            throw new RuntimeException("Recruiter not found with id: " + id);
        }
    }

    /**
     * Delete recruiter by ID
     */
    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }


    public Object createOrUpdate(RecruiterDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrUpdate'");
    }
}
