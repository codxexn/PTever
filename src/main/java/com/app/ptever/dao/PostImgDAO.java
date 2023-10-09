package com.app.ptever.dao;


import com.app.ptever.domain.vo.PostImgVO;
import com.app.ptever.mapper.PostImgMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PostImgDAO {
    private final PostImgMapper postImgMapper;

    // postId로 이미지들 가져오기
    public List<PostImgVO> readAllByPostId(Long postId){
        return postImgMapper.selectAllByPostId(postId);
    }

    // 게시물 작성 시 이미지들 넣기
    public void writeImg(PostImgVO postImgVO){
        postImgMapper.insertImg(postImgVO);
    }

    // 게시물 이미지 수정
    public void modifyImg(PostImgVO postImgVO){
        postImgMapper.updateImg(postImgVO);
    }
}
