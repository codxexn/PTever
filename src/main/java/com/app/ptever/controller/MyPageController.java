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
    @GetMapping("myPage")
    public void GoToMyPage(){;}

//    내 정보
    @GetMapping("myInfo")
    public void  GoToMyInfo(){;}

//    내 강의실
    @GetMapping("myLectures")
    public void GoToMyLectures(){;}

//    내 리뷰
    @GetMapping("myReviews")
    public void GoToMyReviews(){;}

//    설정
    @GetMapping("personalSetting")
    public void GoToPersonalSetting(){;}

//    내 강의영상 목록
    @GetMapping("videoList")
    public void GoToVideoList(){;}

//    내 쿠폰
    @GetMapping("coupon")
    public void GoToCoupon(){;}

//    강의 구매내역
    @GetMapping("purchaseHistory")
    public void GotoPurchaseHistory(){;}



































}
