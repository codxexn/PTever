package com.app.ptever.controller;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.CommunityCommentDTO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.PostImgVO;
import com.app.ptever.domain.vo.UserProfileVO;
import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.repository.CommunityCommentService;
import com.app.ptever.repository.CommunityService;
import com.app.ptever.repository.PostImgService;
import com.app.ptever.repository.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;
    private final CommunityCommentService communityCommentService;
    private final UserProfileService userProfileService;
    private final PostImgService postImgService;

//    전체 게시판
    @GetMapping("full-page")
    public ModelAndView GoToFullPage(Pagination pagination){
        pagination.setTotal(communityService.findAllPostCounts());
        pagination.progress();
        ModelAndView mav = new ModelAndView();
        List<PostDTO> allPosts = communityService.findAll(pagination);
        mav.addObject("allPosts", allPosts);
        mav.addObject("pagination", pagination);
//        log.info(mav.toString());
        return mav;
    }

//    자유 게시판
    @GetMapping("free-post")
    public ModelAndView GoToFreePost(Pagination pagination){
        pagination.setTotal(communityService.findTotalByCommunityId(1L));
        pagination.progress();
        ModelAndView mav = new ModelAndView();
        List<PostDTO> freePosts = communityService.findAllByCommunityId(pagination, 1L);
        mav.addObject("freePosts", freePosts);
        mav.addObject("pagination", pagination);
        return mav;
    }

//    상세보기

    @GetMapping("detail")
    public void showDetail(@RequestParam(value="postId", required = false) Long postId, Model model, HttpSession session, CommunityCommentDTO communityCommentDTO){
        Optional<PostDTO> foundPost = communityService.findByPostId(postId);
        List<CommunityCommentDTO> foundComments = communityCommentService.findAllByPostId(postId);
        List<PostImgVO> foundImages = postImgService.findAllByPostId(postId);
        UserProfileVO userProfileVO = null;
        String currentUserProfilePath = "";
        if (foundPost.isPresent()){
            if (foundPost.get().getUserProfilePath() == null) {
                foundPost.get().setUserProfilePath("/image/user-profile/user-profile-default.png");
            }
            model.addAttribute("post", foundPost.get());
            model.addAttribute("comments", foundComments);
            if (!foundComments.isEmpty()) {
                foundComments.forEach((comment) -> {
                    if (comment.getUserProfilePath() == null) {
                        comment.setUserProfilePath("/image/user-profile/user-profile-default.png");
                    }
                });
            }
            if (!foundImages.isEmpty()) {
                model.addAttribute("foundImages", foundImages);
            } else {
                model.addAttribute("foundImages", null);
            }
        } else {
            model.addAttribute("post", null);
            model.addAttribute("comments", null);
            model.addAttribute("foundImages", null);
        }
        session.setAttribute("postId", postId);
        if (session.getAttribute("user") != null) {
            UserVO currentUser = (UserVO) session.getAttribute("user");
            userProfileVO = userProfileService.findByUserId(currentUser.getUserId());
            if (userProfileVO == null){
                UserProfileVO newUserProfileVO = new UserProfileVO();
                newUserProfileVO.setUserProfilePath("/image/user-profile/user-profile-default.png");
                model.addAttribute("currentUserProfilePath", newUserProfileVO.getUserProfilePath());
            } else {
                if (userProfileVO.getUserProfilePath() == null) {
                    userProfileVO.setUserProfilePath("/image/user-profile/user-profile-default.png");
                }
                model.addAttribute("currentUserProfilePath", userProfileVO.getUserProfilePath());
            }
        } else {
            model.addAttribute("currentUserProfilePath", null);
        }
    }

    @PostMapping("detail")
    public RedirectView showDetailAfterComment(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId, CommunityCommentDTO communityCommentDTO){
        communityCommentDTO.setUserId(userId);
        communityCommentDTO.setPostId(postId);
        communityCommentService.saveComment(communityCommentDTO);
        return new RedirectView("/community/detail?postId=" + postId);
    }

//    내가 쓴 글
    @GetMapping("iWrite")
    public String GoToIWrite(Pagination pagination, HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            return "/login/login";
        }
        UserVO userVO = (UserVO) session.getAttribute("user");
        Long userId = userVO.getUserId();
        pagination.setTotal(communityService.findTotalByUserId(userId));
        pagination.progress();
        List<PostDTO> foundMyPosts = communityService.findAllByUserId(pagination, userId);
        model.addAttribute("foundMyPosts", foundMyPosts);
        model.addAttribute("pagination", pagination);
        return "/community/iWrite";
    }

//    자유게시판 글쓰기

    @GetMapping("write-free")
    public String GoToWriteFree(HttpSession session, UserVO userVO, PostDTO postDTO){
        if (session.getAttribute("user") == null) {
            return "/login/login";
        }
        return "/community/write";
    }

    @PostMapping("write-free")
    public RedirectView uploadFreePost(@RequestParam("userId") Long userId, MultipartHttpServletRequest mhsr, PostDTO postDTO)
    throws IllegalStateException, IOException, Exception{
        postDTO.setUserId(userId);
        communityService.saveFreePost(postDTO);
        List<MultipartFile> files = mhsr.getFiles("files");
        if (!files.isEmpty()) {
            Long postId = communityService.findPostByUserId(userId).getPostId();
            for (MultipartFile file : files) {
                if (file.isEmpty()){
                    continue;
                }
                PostImgVO postImgVO = new PostImgVO();
                postImgVO.setPostId(postId);
                String originFileName = file.getOriginalFilename();
                String fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();
                String absolutePath = new File("").getAbsolutePath() + "\\src\\main\\resources\\static";
                String fileUrl = "/image/post-images/";
                File destinationFile;
                String destinationFileName;
                do {
                    destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                    destinationFile = new File(absolutePath + fileUrl + destinationFileName);
                } while (destinationFile.exists());

                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);

                postImgVO.setFileSize(file.getSize());
                postImgVO.setStoredFileName(destinationFileName);
                postImgVO.setOriginFileName(originFileName);
                postImgVO.setImagePath(fileUrl);
                postImgService.saveImg(postImgVO);
            }
        }
        return new RedirectView("/community/free-post");
    }

//    소도구 거래 게시판 글쓰기

    @GetMapping("write-trans")
    public String GoToWriteTrans(HttpSession session, UserVO userVO, PostDTO postDTO){
        if (session.getAttribute("user") == null) {
            return "/login/login";
        }
        return "/community/write-trans";
    }

    @PostMapping("write-trans")
    public RedirectView uploadTransPost(@RequestParam("userId") Long userId, MultipartHttpServletRequest mhsr, PostDTO postDTO)
    throws Exception {
        postDTO.setUserId(userId);
        communityService.saveTransPost(postDTO);
        List<MultipartFile> files = mhsr.getFiles("files");
        if (!files.isEmpty()) {
            Long postId = communityService.findPostByUserId(userId).getPostId();
            for (MultipartFile file : files) {
                if (file.isEmpty()){
                    continue;
                }
                PostImgVO postImgVO = new PostImgVO();
                postImgVO.setPostId(postId);
                String originFileName = file.getOriginalFilename();
                String fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();
                String absolutePath = new File("").getAbsolutePath() + "\\src\\main\\resources\\static";
                String fileUrl = "/image/post-images/";
                File destinationFile;
                String destinationFileName;
                do {
                    destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                    destinationFile = new File(absolutePath + fileUrl + destinationFileName);
                } while (destinationFile.exists());

                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);

                postImgVO.setFileSize(file.getSize());
                postImgVO.setStoredFileName(destinationFileName);
                postImgVO.setOriginFileName(originFileName);
                postImgVO.setImagePath(fileUrl);
                postImgService.saveImg(postImgVO);
            }
        }
        return new RedirectView("/community/transaction");
    }

//    소도구 거래 게시판
    @GetMapping("transaction")
    public ModelAndView GoToTransaction(Pagination pagination){
        pagination.setTotal(communityService.findTotalByCommunityId(2L));
        pagination.progress();
        ModelAndView mav = new ModelAndView();
        List<PostDTO> transPosts = communityService.findAllByCommunityId(pagination, 2L);
        mav.addObject("transPosts", transPosts);
        mav.addObject("pagination", pagination);
        return mav;
    }

//    게시물 삭제
    @PostMapping("detail-delete")
    public RedirectView deletePostAndGoToAllPosts(@RequestParam("postId") Long postId){
        List<CommunityCommentDTO> foundComments = communityCommentService.findAllByPostId(postId);
        if (!foundComments.isEmpty()){
            communityService.discardCommentByPostId(postId);
        }
        List<PostImgVO> foundImages = postImgService.findAllByPostId(postId);
        if (!foundImages.isEmpty()) {
            communityService.discardImageByPostId(postId);
        }
        communityService.discardByPostId(postId);
        return new RedirectView("/community/full-page");
    }


//    게시물 수정
    @PostMapping("detail-update")
    public String detailUpdate(@RequestParam("postId") Long postId, Model model, PostDTO postDTO){
        Optional<PostDTO> foundPost = communityService.findByPostId(postId);
        if (foundPost.isPresent()){
            model.addAttribute("foundPost", foundPost.get());
        } else {
            model.addAttribute("foundPost", null);
        }
        return "/community/update-post";
    }

    @PostMapping("update-post")
    public RedirectView updatePost(@RequestParam("postId") Long postId, @RequestParam("postTitle") String postTitle,
                                   MultipartHttpServletRequest mhsr, @RequestParam("postContent") String postContent)
    throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postId);
        postDTO.setPostTitle(postTitle);
        postDTO.setPostContent(postContent);
        communityService.revisePost(postDTO);
        List<PostImgVO> foundImages = postImgService.findAllByPostId(postId);
        if (!foundImages.isEmpty()) {
            communityService.discardImageByPostId(postId);
        }
        List<MultipartFile> files = mhsr.getFiles("files");
        if (!files.isEmpty()) {
            for (MultipartFile file : files) {
                if (file.isEmpty()){
                    continue;
                }
                PostImgVO postImgVO = new PostImgVO();
                postImgVO.setPostId(postId);
                String originFileName = file.getOriginalFilename();
                String fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();
                String absolutePath = new File("").getAbsolutePath() + "\\src\\main\\resources\\static";
                String fileUrl = "/image/post-images/";
                File destinationFile;
                String destinationFileName;
                do {
                    destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                    destinationFile = new File(absolutePath + fileUrl + destinationFileName);
                } while (destinationFile.exists());

                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);

                postImgVO.setFileSize(file.getSize());
                postImgVO.setStoredFileName(destinationFileName);
                postImgVO.setOriginFileName(originFileName);
                postImgVO.setImagePath(fileUrl);
                postImgService.saveImg(postImgVO);
            }
        }
        return new RedirectView("/community/detail?postId=" + postId);
    }

//    댓글 삭제
    @PostMapping("delete-comment")
    public RedirectView deleteComment(@RequestParam("communityCommentId") Long communityCommentId, @RequestParam("postId") Long postId){
        communityCommentService.discardComment(communityCommentId);
        return new RedirectView("/community/detail?postId=" + postId);
    }










}
