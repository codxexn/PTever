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

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/withdraw/*")

public class WithdrawController {
    private final UserService userService;

//    회원 탈퇴
    @GetMapping("withdrawMain")
    public void GoToWithdrawMain(UserVO userVO){;}

//    회원 탈퇴 중

    @GetMapping("withdrawNext")
    public String GoToWithdrawNext(UserVO userVO, HttpSession session){
        if (session.getAttribute("user") == null){
            return "/login/login";
        }
        return "/withdraw/withdrawNext";
    }

    @PostMapping("withdrawNext")
    public RedirectView withdraw(HttpSession session, UserVO userVO, @RequestParam("userPassword") String userPassword){
        UserVO loggedInUser = (UserVO) session.getAttribute("user");
        userVO.setUserPassword(loggedInUser.getUserPassword());
        userVO.setUserEmail(loggedInUser.getUserEmail());
        if (userPassword.equals(userVO.getUserPassword())){
            userService.deactivateUser(userVO);
            session.invalidate();
            return new RedirectView("/withdraw/withdrawComplete");
        }
        return new RedirectView("/withdraw/withdrawNext-error");
    }

    @GetMapping("withdrawNext-error")
    public String withdrawError(UserVO userVO, Model model){
        String errorMessage = "비밀번호가 일치하지 않습니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "/withdraw/withdrawNext";
    }

//    회원 탈퇴 완료
    @GetMapping("withdrawComplete")
    public void GoToWithdrawComplete(UserVO userVO){;}
}
