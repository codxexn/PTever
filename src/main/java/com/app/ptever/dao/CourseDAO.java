package com.app.ptever.dao;

import com.app.ptever.domain.dto.CourseDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CourseDAO {
    private final CourseMapper courseMapper;

    //강의 상세보기
    public Optional<CourseDTO> findCourseById(Long courseId) {
        return courseMapper.selectById(courseId);
    }

    public List<ReviewDTO> findAllReviewByCourseId(Long courseId) {
        return courseMapper.selectAllReview(courseId);
    }
}
