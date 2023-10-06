package com.app.ptever.controller;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.repository.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notices/*")
public class NoticesController {
    private final NoticeService noticeService;

//    공지사항
    @GetMapping("notices")
    public void GoToNotices(Model model){
        List<NoticeVO> notices = noticeService.selectNotice();
        model.addAttribute("notice",notices);
    }

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
