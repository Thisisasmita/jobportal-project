package com.jobportal.dto;


import com.jobportal.enums.Action;

public class AdminDTO {

    private Long adminId;
    private Long userId;
    private Action action;

    // Constructors
    public AdminDTO() {}

    public AdminDTO(Long adminId, Long userId, Action action) {
        this.adminId = adminId;
        this.userId = userId;
        this.action = action;
    }

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
