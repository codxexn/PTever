package com.app.ptever.controller;

import com.app.ptever.domain.dto.CommunityCommentDTO;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.repository.CommunityCommentService;
import com.app.ptever.repository.CommunityService;
import com.app.ptever.repository.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor

public class MainController {
    private final MainService mainService;
    private final CommunityCommentService communityCommentService;

    @GetMapping("/")
    public String GoToMain(Model model){
        List<CourseSelectDTO> courseAvgScoreList = mainService.getScoreCourseList();
        List<CourseSelectDTO> courseLatestDateList = mainService.getLatestDateCourseList();
        List<PostDTO> transPosts = mainService.getLatestDateCommunityList();
//        transPosts.forEach((transPost) -> anyway.add(communityCommentService.findAllByPostId(transPost.getPostId())));
        model.addAttribute("courseAvgScoreList", courseAvgScoreList);
        model.addAttribute("courseLatestDateList", courseLatestDateList);
        model.addAttribute("transPosts", transPosts);
        return "mainpage/mainpage";
    }
}
