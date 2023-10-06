package com.app.ptever.dao;

import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.vo.CourseVO;
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

    //    강의 상세보기
    public Optional<CourseVO> findCourseById(Long courseId) {
        return courseMapper.selectById(courseId);
    }
    //    강의 아이디에 해당하는 모든 리뷰 조회
    public List<ReviewDTO> findAllReviewByCourseId(Long courseId) {
        return courseMapper.selectAllReview(courseId);
    }
    //    해당 강의 제외 6개 강의 랜덤으로 조회
    public List<CourseVO> findOtherCourse(Long courseId) {
        return  courseMapper.selectOtherCourse(courseId);
    }
}
