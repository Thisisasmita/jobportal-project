package com.jobportal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.AdminDTO;
import com.jobportal.entity.Admin;
import com.jobportal.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin performAction(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setAdminId(dto.getAdminId());
        admin.setUserId(dto.getUserId());
        admin.setAction(dto.getAction());
        admin.setTimeStamp(LocalDateTime.now());

        return adminRepo.save(admin);
    }

    public List<Admin> getActionsByAdmin(Long adminId) {
        return adminRepo.findByAdminId(adminId);
    }

    public List<Admin> getActionsByUser(Long userId) {
        return adminRepo.findByUserId(userId);
    }
}
