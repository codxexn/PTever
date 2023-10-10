package com.app.ptever.controller;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.FaqVO;
import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.repository.FaqService;
import com.app.ptever.repository.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notices/*")
public class NoticesController {
    private final NoticeService noticeService;
    private final FaqService faqService;



//    공지사항
    @GetMapping("notices")
    public ModelAndView GoToNotices(Model model, Pagination pagination){
        List<NoticeVO> notices = noticeService.selectNotice();
        model.addAttribute("notice",notices);

        pagination.setTotal(noticeService.selectAllCounts());
        pagination.progress();

        ModelAndView mav = new ModelAndView();
        List<NoticeVO> allNotices = noticeService.selectAllNotices(pagination);
        mav.addObject("allNotices",allNotices);
        mav.addObject("pagination",pagination);
//        log.info(mav.toString());
        return mav;
    }

//    자주 묻는 질문
    @GetMapping("frequent-questions")
    public void GoToFrequentQuestions(){;}

//    1대1 문의하기
    @GetMapping("personal-faq-ask")
    public String GoTopersonalFaqAsk(HttpSession session, FaqVO faqVO){
        if(session.getAttribute("user")==null){
            return "/login/login";
        }

        return "/notices/personal-faq-ask";
    }

    @PostMapping("personal-faq-ask")
    public RedirectView writeFaq(@RequestParam("userId") Long userId, FaqVO faqVO)
    {
        faqVO.setUserId(userId);

        faqService.register(faqVO);

        return new RedirectView("/notices/personal-faq-list");
    }

//    1대1 문의 목록
    @GetMapping("personal-faq-list")
    public void GoTopersonalFaqList(HttpSession session,Long userId, Pagination pagination){
//        pagination.setTotal(faqService.findTotalByUserId(session));
//        pagination.progress();
//        ModelAndView mav = new ModelAndView();
//        List<FaqVO> faqlist=faqService.findAllByUserId(pagination,userId);
//        mav.addObject("faqlist",faqlist);
//        mav.addObject("pagination",pagination);

    }
}
