package com.app.ptever.repository;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ShoppingMallSelectDTO;
import com.app.ptever.domain.vo.PostImgVO;

import java.util.List;

public interface MainService {
    // 강의 별점순으로 가져오기
    public List<CourseSelectDTO> getScoreCourseList();

    // 강의 최신순으로 가져오기
    public List<CourseSelectDTO> getLatestDateCourseList();

    public List<ShoppingMallSelectDTO> getRegisterDateProductList();

    // 최신순으로 개별 게시판 게시물 조회(메인에는 소도구 거래만)
    public List<PostDTO> getLatestDateCommunityList();

    // postId로 이미지들 가져오기
    public List<PostImgVO> findAllByPostId(Long postId);
}
