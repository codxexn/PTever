package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agreements/*")
public class AgreementsController {

//    이용약관
    @GetMapping("agreements")
    public void GoToAgreements(){;}

//    위치기반 서비스 이용약관
    @GetMapping("location-agreement")
    public void GoToLocationAgreement(){;}

//    개인정보 처리방침
    @GetMapping("privacy")
    public void GoToPrivacy(){;}
}
