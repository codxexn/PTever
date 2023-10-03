package com.app.ptever.controller;


import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.repository.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import javax.xml.ws.Service;
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
            UserVO user = foundUser.get();
            if (user.getUserState().equals("WITHDRAWN")){
                return new RedirectView("/login/login");
            }
            session.setAttribute("user", foundUser.get());
            return new RedirectView("/");
        }
        return new RedirectView("/login/login-error");
    }

    @GetMapping("login-error")
    public String GoToLoginAgain(UserVO userVO, Model model){
        String errorMessage = "이메일 또는 비밀번호가 잘못되었습니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "/login/login";
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
        // 이메일 중복 확인을 위해 비번찾기 시 사용하는 메소드를 여기서도 호출합니다.(checkByEmail())
        String userEmail = userVO.getUserEmail();
        Optional<UserVO> existUser = userService.checkByEmail(userEmail);
        if (existUser.isPresent()){
            String userState = existUser.get().getUserState();
            if (userState != null){
                if (userState.equals("ACTIVE")){
                    // 탈퇴하지 않은 일반 회원으로 중복될 경우에만 다시 입력하도록 합니다.
                    return new RedirectView("/login/sign-up-email-error");
                } else {
                    // sign-up-email2에서 활용할 수 있도록 setter 활용
                    userVO.setUserState(userState);
                }
            }
        }
        // 그렇지 않을 경우 위에서 return을 만나지 않고 아래 코드로 정상적으로 돌입합니다.
        session.setAttribute("user", userVO);
        return new RedirectView("/login/sign-up-email2");
    }

    @GetMapping("sign-up-email-error")
    public String alreadyExistEmail(UserVO userVO, Model model){
        String errorMessage = "이미 가입한 회원입니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "/login/sign-up-email";
    }

    @GetMapping("sign-up-email2")
    public void GoToSignUpEmail2(UserVO userVO){;}

    @PostMapping("sign-up-email2")
    public RedirectView signUp(UserVO userVO, @RequestParam("userEmail") String inputEmail, @RequestParam("userPassword") String inputPassword, @RequestParam("userState") String inputState, HttpSession session){
        userVO.setUserEmail(inputEmail);
        userVO.setUserPassword(inputPassword);
        if (inputState == null){
            // 완전히 새로운 회원일 경우
            userService.save(userVO);
        } else {
            // 기존에 탈퇴했던 회원일 경우 update쿼리문 날려야함
            userService.resave(userVO);
        }
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
    public void GoToFindPassword(String userEmail){;}

    @PostMapping("find-password")
    public RedirectView checkByEmail(@RequestParam("userEmail") String userEmail){
        Optional<UserVO> foundUser = userService.checkByEmail(userEmail);
        if (foundUser.isPresent()){
            return new RedirectView("/login/find-passwordToSendEmail");
        }
        return new RedirectView("/login/find-password");
    }

    //    인증번호 메일로 보내기
    @GetMapping("find-passwordToSendEmail")
    public void GoToFindPasswordToSendEmail(){;}

    //    비밀번호 변경
    @GetMapping("changePassword")
    public void GoToChangePassword(){;}








}