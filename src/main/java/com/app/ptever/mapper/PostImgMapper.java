package com.app.ptever.mapper;

import com.app.ptever.domain.vo.PostImgVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostImgMapper {

    // postId로 이미지들 가져오기
    public List<PostImgVO> selectAllByPostId(Long postId);

    // 게시물 작성 시 이미지들 넣기
    public void insertImg(PostImgVO postImgVO);

    // 게시물 이미지 수정
    public void updateImg(PostImgVO postImgVO);
}
