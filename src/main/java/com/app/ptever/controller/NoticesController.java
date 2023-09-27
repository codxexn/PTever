package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notices/*")
public class NoticesController {

//    공지사항
    @GetMapping("notices")
    public void GoToNotices(){;}

//    자주 묻는 질문
    @GetMapping("frequent-questions")
    public void GoToFrequentQuestions(){;}

//    1대1 문의하기
    @GetMapping("personal-faq-ask")
    public void GoTopersonalFaqAsk(){;}

//    1대1 문의 목록
    @GetMapping("personal-faq-list")
    public void GoTopersonalFaqList(){;}


}
