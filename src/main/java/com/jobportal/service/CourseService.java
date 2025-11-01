package com.jobportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobportal.dto.CourseDTO;
import com.jobportal.entity.Course;
import com.jobportal.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepo;

    public CourseDTO addCourse(CourseDTO dto) {
        Course course = Course.builder()
                .courseTitle(dto.getCourseTitle())
                .courseDescription(dto.getCourseDescription())
                .courseCategory(dto.getCourseCategory())
                .adminId(dto.getAdminId())
                .createdAt(LocalDateTime.now())
                .active(true)
                .build();

        courseRepo.save(course);

        dto.setId(course.getId());
        dto.setActive(course.isActive());

        return dto;
    }

    public List<CourseDTO> getAllActiveCourses() {
        return courseRepo.findByActiveTrue().stream()
                .map(c -> CourseDTO.builder()
                        .id(c.getId())
                        .courseTitle(c.getCourseTitle())
                        .courseDescription(c.getCourseDescription())
                        .courseCategory(c.getCourseCategory())
                        .adminId(c.getAdminId())
                        .active(c.isActive())
                        .build())
                .collect(Collectors.toList());
    }

    public void deactivateCourse(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setActive(false);
        courseRepo.save(course);
    }
}
