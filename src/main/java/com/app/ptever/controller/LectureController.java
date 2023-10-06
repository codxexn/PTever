package com.app.ptever.controller;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.CourseVO;
import com.app.ptever.repository.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lecture/*")
public class LectureController {
    // 서비스 주입
    private final CourseService courseService;
//    강의 목록
    @GetMapping("lecture-list")
    public void GoToLectureList(){;}

//    강의 전체 목록
    @GetMapping("lecture-list-all")
    public ModelAndView GoToAllCourseListPage(Pagination pagination){
        pagination.setTotal(courseService.getAllCoursesCounts());
        pagination.progress();
        ModelAndView mv = new ModelAndView();
        List<CourseVO> allCourses = courseService.findAllCourses(pagination);
        mv.addObject("allCourses", allCourses);
        mv.addObject("pagination", pagination);
    //        log.info(mv.toString());
        return mv;
    }

//    강의 상세보기
//    @GetMapping("lecture-detailpage")
//    public void GoToLectureDetail(ReviewDTO reviewDTO, CourseDTO courseDTO){;}

//    강의 상세보기
    @GetMapping("lecture-detailpage/{id}")
    public ModelAndView findCourseDetailById(@PathVariable("id") Long courseId){
        ModelAndView mv = new ModelAndView();
        Optional<CourseVO> foundCourse = courseService.findCourseById(courseId);
        List<ReviewDTO> foundReviews = courseService.findAllReviewByCourseId(courseId);
        List<CourseVO> foundOtherCourses = courseService.findOtherCourse(courseId);
        Double getCourseScoreAVG = courseService.getAvgByCourseId(courseId);
        if(foundCourse.isPresent()) {
            log.info(foundCourse.toString());
            foundReviews.stream().map(ReviewDTO::toString).forEach(log::info);
            foundOtherCourses.stream().map(CourseVO::toString).forEach(log::info);
            mv.addObject("courseVO", foundCourse.get());
            mv.addObject("reviewDTOS", foundReviews);
            mv.addObject("courseVOS", foundOtherCourses);
            mv.addObject("AVG", getCourseScoreAVG);
            mv.setViewName("/lecture/lecture-detailpage");
            return mv;
        }
        return mv;
    }
}


