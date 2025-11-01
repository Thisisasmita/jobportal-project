package com.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.entity.Jobseeker;

@Repository
public interface JobSeekerRepository  extends JpaRepository<Jobseeker,Long>{
    Optional<Jobseeker>findByEmail(String email);

}
