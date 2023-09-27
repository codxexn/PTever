package com.app.ptever.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {

//    로그인

    @GetMapping("login")
    public void GoToLogin(){;}

//    회원가입
    @GetMapping("sign-up")
   public void GoToSignUp(){;}

//    이메일 회원가입
    @GetMapping("sign-up-email")
    public void GoToSignUpEmail(){;}

    //    이메일 회원 가입 다음 페이지
        @GetMapping("sign-up-email2")
    public void GoToSignUpEmail2(){;}

//    비밀번호 찾기
    @GetMapping("find-password")
    public void GoToFindPassword(){;}

//    인증번호 메일로 보내기
    @GetMapping("find-passwordToSendEmail")
    public void GoToFindPasswordToSendEmail(){;}

//    비밀번호 변경
    @GetMapping("changePassword")
    public void GoToChangePassword(){;}








}
