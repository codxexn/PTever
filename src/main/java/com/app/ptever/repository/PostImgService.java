package com.app.ptever.repository;

import com.app.ptever.domain.vo.PostImgVO;

import java.util.List;

public interface PostImgService {

    // postId로 이미지들 가져오기
    public List<PostImgVO> findAllByPostId(Long postId);

    // 게시물 작성 시 이미지 넣기
    public void saveImg(PostImgVO postImgVO);

    // 게시물 이미지 수정
    public void reviseImg(PostImgVO postImgVO);
}
