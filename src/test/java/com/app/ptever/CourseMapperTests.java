package com.app.ptever;

import com.app.ptever.dao.CourseDAO;
import com.app.ptever.domain.dto.CourseDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.mapper.CourseMapper;
import com.app.ptever.repository.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseMapperTests {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CourseService courseService;



    @Test
    public void selectByIdTest() {
        courseMapper.selectById(3L).map(CourseDTO::toString).ifPresent(log::info);
    }

    @Test
    public void findCourseByIdTest() {
        courseDAO.findCourseById(3L).map(CourseDTO::toString).ifPresent(log::info);
    }

    @Test
    public void findCourseByIdServiceTest() {
        courseService.findCourseById(3L).map(CourseDTO::toString).ifPresent(log::info);
    }
    @Test
    public void selectAllReviewTest() {
        courseMapper.selectAllReview(39L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

    @Test
    public void findAllReviewByCourseIdTest() {
        courseDAO.findAllReviewByCourseId(39L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

    @Test
    public void findAllReviewByCourseId() {
        courseService.findAllReviewByCourseId(39L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

}
