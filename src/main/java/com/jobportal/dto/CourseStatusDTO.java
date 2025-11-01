package com.jobportal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseStatusDTO {
    private int totalCourses;
    private int activeCourses;
    private int inactiveCourses;
    public int getTotalCourses() {
        return totalCourses;
    }
    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }
    public int getActiveCourses() {
        return activeCourses;
    }
    public void setActiveCourses(int activeCourses) {
        this.activeCourses = activeCourses;
    }
    public int getInactiveCourses() {
        return inactiveCourses;
    }
    public void setInactiveCourses(int inactiveCourses) {
        this.inactiveCourses = inactiveCourses;
    }


}
