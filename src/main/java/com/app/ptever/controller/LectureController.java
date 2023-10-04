package com.app.ptever.controller;

import com.app.ptever.domain.dto.CourseDTO;
import com.app.ptever.repository.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public void GoToLectureListAll(){;}

//    강의 상세보기
    @GetMapping("lecture-detailpage")
    public void GoToLectureDetail(){;}

//    강의 상세보기
    @GetMapping("lecture-detailpage/{id}")
    public ModelAndView findCourseDetailById(@PathVariable("id")Long courseId){
        ModelAndView mv = new ModelAndView();
        Optional<CourseDTO> foundCourse = courseService.findCourseById(courseId);
        if(foundCourse.isPresent()) {
            CourseDTO courseDTO = foundCourse.get();
            log.info(courseDTO.toString());
            mv.addObject("courseDTO", courseDTO);
            mv.setViewName("/lecture/lecture-detailpage");
            return mv;
        }
        return mv;
    }
}


