package com.app.ptever.controller;

import com.app.ptever.domain.dto.CommunityCommentDTO;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ShoppingMallSelectDTO;
import com.app.ptever.domain.vo.PostImgVO;
import com.app.ptever.repository.CommunityCommentService;
import com.app.ptever.repository.CommunityService;
import com.app.ptever.repository.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ShoppingMallSelectDTO> productRegisterList = mainService.getRegisterDateProductList();
        List<PostDTO> transPosts = mainService.getLatestDateCommunityList();
//        Map<PostDTO, List<String>> postImageMap = new HashMap<>();

        if(transPosts != null) {
            transPosts.forEach(post -> {
                List<PostImgVO> postImages = mainService.findAllByPostId(post.getPostId());

                if(postImages != null && !postImages.isEmpty()) {
                    post.setImagePath(postImages.get(0).getImagePath() + postImages.get(0).getStoredFileName());
                } else {
                    post.setImagePath("/image/sumin/003.png");
                }
            });
        }
//        transPosts.forEach((transPost) -> anyway.add(communityCommentService.findAllByPostId(transPost.getPostId())));
        model.addAttribute("courseAvgScoreList", courseAvgScoreList);
        model.addAttribute("courseLatestDateList", courseLatestDateList);
        model.addAttribute("productRegisterList", productRegisterList);
        model.addAttribute("transPosts", transPosts);

        return "mainpage/mainpage";
    }
}
