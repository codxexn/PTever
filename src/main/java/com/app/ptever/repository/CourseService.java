package com.app.ptever.repository;

import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.vo.CourseVO;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    // 강의 상세보기
    public Optional<CourseVO> findCourseById(Long courseId);

    //    강의 아이디에 해당하는 모든 리뷰 조회
    public List<ReviewDTO> findAllReviewByCourseId(Long courseId);


}
