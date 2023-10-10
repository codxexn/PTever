package com.app.ptever.controller;


import com.app.ptever.domain.dto.PasswordMailDTO;
import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.repository.KakaoService;
import com.app.ptever.repository.UserProfileService;
import com.app.ptever.repository.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    private final KakaoService kakaoService;
    private final UserProfileService userProfileService;
    private String CLIENT_ID = "c8b8e53a7e7ef6e2b7449cc4f0a8ac9f";
    private String LOGOUT_REDIRECT_URI = "http://localhost:10000/login/logout-finally";
    private String LOGOUT_START_REDIRECT_URI = "http://localhost:10000/login/logout-before-start";

//    로그인

    @GetMapping("login")
    public void GoToLogin(UserVO userVO){;}

    @PostMapping("login")
    public RedirectView login(UserVO userVO, HttpSession session){
        Optional<UserVO> foundUser = userService.login(userVO);
        if(foundUser.isPresent()){
            UserVO user = foundUser.get();
            if (user.getUserState().equals("WITHDRAWN")){
                return new RedirectView("/login/login-error");
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
    public RedirectView kakaoLogoutFirst(HttpSession session){
        if (session.getAttribute("user") != null){
            UserVO userVO = (UserVO) session.getAttribute("user");
            if (userVO.getUserLoginCode().equals("KAKAO")) {
                return new RedirectView("https://kauth.kakao.com/oauth/logout?client_id=" + CLIENT_ID +
                        "&logout_redirect_uri=" + LOGOUT_REDIRECT_URI);
            }
        }
        return new RedirectView("/login/logout-finally");

    }

    @GetMapping("logout-finally")
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
        if (inputState.isEmpty()){
            // 완전히 새로운 회원일 경우
            userService.save(userVO);
        } else {
            // 기존에 탈퇴했던 회원일 경우 update쿼리문 날려야함
            userService.resave(userVO);
        }
        session.invalidate();
        return new RedirectView("/login/login");
    }

//    카카오 회원가입
    @GetMapping("logout-before-start")
    public RedirectView logoutKakaoBeforeStart(){
        return new RedirectView("https://kauth.kakao.com/oauth/authorize?client_id=c8b8e53a7e7ef6e2b7449cc4f0a8ac9f&redirect_uri=http://localhost:10000/login/kakao/callback&response_type=code");
    }

    @GetMapping("kakao/callback")
    public RedirectView kakaoLogin(String code, HttpSession session, RedirectAttributes redirectAttributes, Model model){
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<UserDTO> foundInfo = kakaoService.getKakaoInfo(token);
        if (foundInfo.isPresent()){
            UserDTO userDTO = foundInfo.get();
            String userEmail = userDTO.getUserKakaoEmail();
            if (userService.checkByEmail(userEmail).isPresent()){
                String userState = userService.checkByEmail(userEmail).get().getUserState();
                if (userState.equals("ACTIVE")){
                    return new RedirectView("/login/login-error-kakao");
                } else {
                    userService.reactivateToActiveByKakao(userDTO);
                    return new RedirectView("/login/login");
                }
            }
            model.addAttribute("kakaoErrorMessage", null);
            model.addAttribute("kakaoErrorMessage2", null);
            userService.saveKakao(userDTO);
            Long userId = userService.checkByEmail(userEmail).get().getUserId();
            userDTO.setUserId(userId);
            userProfileService.saveKakaoProfile(userDTO);
            UserVO userVO = new UserVO();
            userVO.setUserEmail(userDTO.getUserKakaoEmail());
            userVO.setUserPassword("1234");
            Optional<UserVO> foundUser = userService.login(userVO);
            session.setAttribute("user", foundUser.get());
            return new RedirectView("/");
        }
        return new RedirectView("/login/sign-up");

    }

    @GetMapping("login-error-kakao")
    public String kakaoLoginError(Model model, UserVO userVO, HttpSession session){
        String kakaoErrorMessage = "이미 존재하는 이메일 주소이거나 이미 가입하신 카카오 회원입니다. 로그인을 먼저 진행해주세요.";
        String kakaoErrorMessage2 = "카카오 회원가입을 하셨다면 초기 비밀번호는 1234입니다. 로그인 후 비밀번호 변경을 권장드립니다.";
        model.addAttribute("kakaoErrorMessage", kakaoErrorMessage);
        model.addAttribute("kakaoErrorMessage2", kakaoErrorMessage2);
        return "/login/login";
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
            PasswordMailDTO passwordMailDTO = userService.createMailAndChangePassword(userEmail);
            userService.sendEmail(passwordMailDTO);
            return new RedirectView("/login/find-passwordToSendEmail");
        }
        return new RedirectView("/login/find-password-error");
    }

    @GetMapping("find-password-error")
    public String checkEmailError(String userEmail, Model model){
        String errorMessage = "등록되지 않은 이메일입니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "/login/find-password";
    }

    //    인증번호 메일로 보내기
    @GetMapping("find-passwordToSendEmail")
    public void GoToFindPasswordToSendEmail(){;}

    //    비밀번호 변경
    @GetMapping("changePassword")
    public void GoToChangePassword(HttpSession session, String oldPassword, String newPassword){;}

    @PostMapping("changePassword")
    public RedirectView changePassword(HttpSession session, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword){
        if (session.getAttribute("user") == null){
            return new RedirectView("/login/login");
        }
        UserVO currentUser = (UserVO) session.getAttribute("user");
        if (!currentUser.getUserPassword().equals(oldPassword)) {
            return new RedirectView("/login/changePassword-error");
        }
        userService.saveNewPassword(currentUser.getUserEmail(), newPassword);
        return new RedirectView("/login/login");
    }

    @GetMapping("changePassword-error")
    public String checkPasswordError(Model model){
        String errorMessage = "기존 비밀번호가 일치하지 않습니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "/login/changePassword";
    }









}