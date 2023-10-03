package com.app.ptever.controller;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.repository.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor

public class MainController {
    private final MainService mainService;
    @GetMapping("/")
    public String GoToMain(Model model){
        List<CourseSelectDTO> courseList = mainService.getScoreCourseList();
        model.addAttribute("courseAvgScoreList", courseList);
        return "mainpage/mainpage";
    }
}
