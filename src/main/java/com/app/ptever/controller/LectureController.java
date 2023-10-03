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

//    강의 상세보기
    @GetMapping("lecture-detailpage/{id}")
    public RedirectView findCourseDetailById(@PathVariable("id")Long courseId){
        Optional<CourseDTO> foundCourse = courseService.findCourseById(courseId);
        if(foundCourse.isPresent()) {
            CourseDTO courseDTO = foundCourse.get();
            log.info(courseDTO.toString());
            return new RedirectView("/lecture/lecture-detailpage/");
        }
        return new RedirectView("/lecture-list/");
    }
}

