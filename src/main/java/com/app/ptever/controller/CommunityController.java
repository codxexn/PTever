package com.app.ptever.controller;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.CommunityCommentDTO;
import com.app.ptever.domain.vo.UserVO;
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
    public void showDetail(@RequestParam(value="postId", required = false) Long postId, Model model, HttpSession session, CommunityCommentDTO communityCommentDTO){
        Optional<PostDTO> foundPost = communityService.findByPostId(postId);
        List<CommunityCommentDTO> foundComments = communityCommentService.findAllByPostId(postId);
        if (foundPost.isPresent()){
            model.addAttribute("post", foundPost.get());
            model.addAttribute("comments", foundComments);
        } else {
            model.addAttribute("post", null);
            model.addAttribute("comments", null);
        }
        session.setAttribute("postId", postId);
    }

    @PostMapping("detail")
    public RedirectView showDetailAfterComment(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId, CommunityCommentDTO communityCommentDTO){
        communityCommentDTO.setCommunityId(1L);
        communityCommentDTO.setUserId(userId);
        communityCommentDTO.setPostId(postId);
        communityCommentService.saveComment(communityCommentDTO);
        return new RedirectView("/community/detail?postId=" + postId);
    }

//    내가 쓴 글
    @GetMapping("iWrite")
    public String GoToIWrite(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            return "/login/login";
        }
        UserVO userVO = (UserVO) session.getAttribute("user");
        List<PostDTO> foundMyPosts = communityService.findAllByUserId(userVO.getUserId());
        model.addAttribute("foundMyPosts", foundMyPosts);
        return "/community/iWrite";
    }

//    글쓰기

    @GetMapping("write")
    public String GoToWrite(HttpSession session, UserVO userVO){
        if (session.getAttribute("user") == null) {
            return "/login/login";
        }
        return "/community/write";
    }

//    소도구 거래 게시판
    @GetMapping("transaction")
    public ModelAndView GoToTransaction(){
        ModelAndView mav = new ModelAndView();
        List<PostDTO> transPosts = communityService.findAllByCommunityId(2L);
        mav.addObject("transPosts", transPosts);
        return mav;
    }

//    게시물 삭제
    @PostMapping("detail-delete")
    public RedirectView deletePostAndGoToAllPosts(@RequestParam("postId") Long postId){
        List<CommunityCommentDTO> foundComments = communityCommentService.findAllByPostId(postId);
        if (!foundComments.isEmpty()){
            communityService.discardCommentByPostId(postId);
        }
        communityService.discardByPostId(postId);
        return new RedirectView("/community/full-page");
    }










}
