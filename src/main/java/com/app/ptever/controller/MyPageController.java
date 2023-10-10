package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage/*")
public class MyPageController {

//    마이페이지
    @GetMapping("mypage")
    public void GoToMyPage(){;}

//    내 정보
    @GetMapping("my-info")
    public void  GoToMyInfo(){;}

//    내 강의실
    @GetMapping("no-lectures")
    public void GoToMyLectures(){;}

    @GetMapping("my-lectures")
    public void GoToLectures(){;}

//    내 리뷰

    @GetMapping("no-reviews")
    public void GoToReviews(){;}
    @GetMapping("my-reviews")
    public void GoToMyReviews(){;}

//    설정
    @GetMapping("personal-setting")
    public void GoToPersonalSetting(){;}

//    내 강의영상 목록
    @GetMapping("video-list")
    public void GoToVideoList(){;}

//    내 쿠폰
    @GetMapping("no-coupon")
    public void GoToNoCoupon(){;}
    @GetMapping("coupon")
    public void GoToCoupon(){;}

//    강의 구매내역

    @GetMapping("no-history")
    public void GoToNoHistory(){;}

    @GetMapping("purchase-history")
    public void GoToPurchaseHistory(){;}



































}
