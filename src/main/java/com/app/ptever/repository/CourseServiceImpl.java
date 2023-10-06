package com.app.ptever.repository;

import com.app.ptever.dao.CourseDAO;
import com.app.ptever.domain.dto.ReviewDTO;
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
}
