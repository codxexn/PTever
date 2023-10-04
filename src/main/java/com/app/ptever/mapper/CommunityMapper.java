package com.app.ptever.mapper;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommunityMapper {

    // 전체게시판에서 전체 게시물 최신순으로 조회
    public List<PostDTO> selectAll();

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> selectByPostId(Long postId);

    // 개별 게시판 전체 게시물 최신순으로 조회
    public List<PostDTO> selectAllByCommunityId(Long communityId);

}
