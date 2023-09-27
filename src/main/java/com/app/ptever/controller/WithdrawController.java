package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/withdraw/*")

public class WithdrawController {

//    회원 탈퇴
    @GetMapping("withdrawMain")
    public void GoToWithdrawMain(){;}

//    회원 탈퇴 중

    @GetMapping("withdrawNext")
    public void GoToWithdrawNext(){;}

//    회원 탈퇴 완료
    @GetMapping("withdrawComplete")
    public void GoToWithdrawComplete(){;}
}
