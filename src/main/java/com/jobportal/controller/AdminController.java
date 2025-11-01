package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.AdminDTO;
import com.jobportal.entity.Admin;
import com.jobportal.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/action")
    public ResponseEntity<Admin> performAction(@RequestBody AdminDTO dto) {
        return ResponseEntity.ok(adminService.performAction(dto));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Admin>> getLogsByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminService.getActionsByAdmin(adminId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Admin>> getLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(adminService.getActionsByUser(userId));
    }
}
