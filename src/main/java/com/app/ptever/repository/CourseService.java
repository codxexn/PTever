package com.app.ptever.repository;

import com.app.ptever.domain.dto.CourseDTO;

import java.util.Optional;

public interface CourseService {

    // 강의 상세보기
    public Optional<CourseDTO> findCourseById(Long courseId);
}
