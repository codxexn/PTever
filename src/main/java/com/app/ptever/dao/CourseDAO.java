package com.app.ptever.dao;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.pagination.Pagination;
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

    //    해당 강의에 대한 평점을 강의 후기 테이블에서 가지고 온 뒤 평균 내기
    public Double findAvgByCourseId(Long courseId) {
        return courseMapper.selectAvgByCourseId(courseId);
    }

    // 전체 강의 목록 최신순으로 가지고 오기
    public List<CourseSelectDTO> findAllCourses(Pagination pagination){
        return courseMapper.selectAllCourse(pagination);
    }

    // 강의 전체 개수 조회
    public int getAllCoursesCounts() {
        return courseMapper.selectTotalAllCourse();
    }
}
