package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/like/*")
public class LikeController {
//    찜한 강의
    @GetMapping("like-lecture")
    public void GoToLikeLectures(){;}

//    찜한 상품
    @GetMapping("likeProduct")
    public void GoToLikeProduct(){;}

//    찜한 트레이너

    @GetMapping("likeTrainer")
    public void GoToLikeTrainer(){;};
}
