package com.app.ptever.repository;

import com.app.ptever.dao.CourseDAO;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.CourseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;
    @Override
    public Optional<CourseVO> findCourseById(Long courseId) {
        return courseDAO.findCourseById(courseId);
    }

    @Override
    public List<ReviewDTO> findAllReviewByCourseId(Long courseId) {
        return courseDAO.findAllReviewByCourseId(courseId);
    }

    @Override
    public List<CourseVO> findOtherCourse(Long courseId) {
      return courseDAO.findOtherCourse(courseId);
    }

    @Override
    public Double getAvgByCourseId(Long courseId) {
        return courseDAO.findAvgByCourseId(courseId);
    }

    @Override
    public List<CourseVO> findAllCourses(Pagination pagination){
        return courseDAO.findAllCourses(pagination);
    }

    @Override
    public int getAllCoursesCounts() {
        return courseDAO.getAllCoursesCounts();
    }
}
