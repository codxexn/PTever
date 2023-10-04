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
        List<CourseSelectDTO> courseAvgScoreList = mainService.getScoreCourseList();
        List<CourseSelectDTO> courseLatestDateList = mainService.getLatestDateCourseList();
        model.addAttribute("courseAvgScoreList", courseAvgScoreList);
        model.addAttribute("courseLatestDateList", courseLatestDateList);
        return "mainpage/mainpage";
    }
}
