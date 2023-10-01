package com.app.ptever.controller;


import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.repository.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private final UserService userService;

//    로그인

    @GetMapping("login")
    public void GoToLogin(UserVO userVO){;}

    @PostMapping("login")
    public RedirectView login(UserVO userVO, HttpSession session){
        Optional<UserVO> foundUser = userService.login(userVO);
        if(foundUser.isPresent()){
            session.setAttribute("user", foundUser.get());
            return new RedirectView("/");
        }
        return new RedirectView("/login/login");
    }

//    로그아웃

    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        if(session != null) {
            session.invalidate();
        }

        return new RedirectView("/");
    }


    //    회원가입
    @GetMapping("sign-up")
    public void GoToSignUp(UserVO userVO){;}

    @GetMapping("sign-up-email")
    public void GoToSignUpEmail(UserVO userVO){;}

    @PostMapping ("sign-up-email")
    public RedirectView addInfoToSignUp(UserVO userVO, HttpSession session){
        session.setAttribute("user", userVO);
        return new RedirectView("/login/sign-up-email2");
    }

    @GetMapping("sign-up-email2")
    public void GoToSignUpEmail2(UserVO userVO){;}

    @PostMapping("sign-up-email2")
    public RedirectView signUp(UserVO userVO, @RequestParam("userEmail") String inputEmail, @RequestParam("userPassword") String inputPassword, HttpSession session){
        userVO.setUserEmail(inputEmail);
        userVO.setUserPassword(inputPassword);
        userService.save(userVO);
        session.invalidate();
        return new RedirectView("/login/login");
    }

//    //    이메일 회원가입
//    @GetMapping("sign-up-email")
//    public void GoToSignUpEmail(){;}
//
//    //    이메일 회원 가입 다음 페이지
//    @GetMapping("sign-up-email2")
//    public void GoToSignUpEmail2(){;}

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