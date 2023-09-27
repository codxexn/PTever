package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {

//    전체 게시판
    @GetMapping("full-page")
    public void GoToFullPage(){;}

//    자유 게시판
    @GetMapping("free-post")
    public void GoToFreePost(){;}

//    자유 게시판 상세보기
    @GetMapping("detail")
    public void GoToDetail(){;}

//    내가 쓴 글
    @GetMapping("iWrite")
    public void GoToIWrite(){;}

//    글쓰기

    @GetMapping("write")
    public void GoToWrite(){;}

//    소도구 거래 게시판
    @GetMapping("transaction")
    public void GoToTransaction(){;}












}
