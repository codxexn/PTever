package com.app.ptever.controller;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.CommunityCommentDTO;
import com.app.ptever.domain.vo.CommunityCommentVO;
import com.app.ptever.domain.vo.PostVO;
import com.app.ptever.repository.CommunityCommentService;
import com.app.ptever.repository.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;
    private final CommunityCommentService communityCommentService;

//    전체 게시판
    @GetMapping("full-page")
    public ModelAndView GoToFullPage(){
        ModelAndView mav = new ModelAndView();
        List<PostDTO> allPosts = communityService.findAll();
        mav.addObject("allPosts", allPosts);
//        log.info(mav.toString());
        return mav;
    }

//    자유 게시판
    @GetMapping("free-post")
    public ModelAndView GoToFreePost(){
        ModelAndView mav = new ModelAndView();
        List<PostDTO> freePosts = communityService.findAllByCommunityId(1L);
        mav.addObject("freePosts", freePosts);
        return mav;
    }

//    자유 게시판 상세보기

    @GetMapping("detail")
    public void showDetail(@RequestParam(value="postId", required = false) Long postId, Model model){
        Optional<PostDTO> foundPost = communityService.findByPostId(postId);
        List<CommunityCommentDTO> foundComments = communityCommentService.findAllByPostId(postId);
        if (foundPost.isPresent()){
            model.addAttribute("post", foundPost.get());
            model.addAttribute("comments", foundComments);
        } else {
            model.addAttribute("post", null);
            model.addAttribute("comments", null);
        }
    }

//    내가 쓴 글
    @GetMapping("iWrite")
    public void GoToIWrite(){;}

//    글쓰기

    @GetMapping("write")
    public void GoToWrite(HttpSession session){;}

//    소도구 거래 게시판
    @GetMapping("transaction")
    public void GoToTransaction(){;}












}
