package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lecture/*")
public class LectureController {
//    강의 목록
    @GetMapping("lecture-list")
    public void GoToLectureList(){;}

//    강의 상세보기
    @GetMapping("lecture-detailpage")
    public void GoToLectureDetail(){;}
}
