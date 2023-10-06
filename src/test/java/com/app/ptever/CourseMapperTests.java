package com.app.ptever;

import com.app.ptever.dao.CourseDAO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.vo.CourseVO;
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


//  강의 상세 조회 Test
    @Test
    public void selectByIdMapperTest() {
        courseMapper.selectById(3L).map(CourseVO::toString).ifPresent(log::info);
    }

    @Test
    public void findCourseByIdDAOTest() {
        courseDAO.findCourseById(3L).map(CourseVO::toString).ifPresent(log::info);
    }

    @Test
    public void findCourseByIdServiceTest() {
        courseService.findCourseById(3L).map(CourseVO::toString).ifPresent(log::info);
    }

//   해당 강의 전체 리뷰 조회 Test
    @Test
    public void selectAllReviewMapperTest() {
        courseMapper.selectAllReview(39L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

    @Test
    public void findAllReviewByCourseIdDAOTest() {
        courseDAO.findAllReviewByCourseId(39L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

    @Test
    public void findAllReviewByCourseIdServiceTest() {
        courseService.findAllReviewByCourseId(61L).stream().map(ReviewDTO::toString).forEach(log::info);
    }

//    해당 강의 제외 6개 강의 랜덤으로 조회 Test
    @Test
    public void selectOtherCourseMapperTest() {
        courseMapper.selectOtherCourse(67L).stream().map(CourseVO::toString).forEach(log::info);
    }

    @Test
    public void findOtherCourseDAOTest() {
        courseDAO.findOtherCourse(64L).stream().map(CourseVO::toString).forEach(log::info);
    }

    @Test
    public void findOtherCourseServiceTest() {
        courseService.findOtherCourse(61L).stream().map(CourseVO::toString).forEach(log::info);
    }
}
