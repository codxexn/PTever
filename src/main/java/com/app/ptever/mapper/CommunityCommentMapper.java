package com.app.ptever.mapper;


import com.app.ptever.domain.dto.CommunityCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityCommentMapper {
    // 각 게시물 별 댓글 가져오기
    public List<CommunityCommentDTO> selectAllByPostId(Long postId);

    // 댓글 달기
    public void insertComment(CommunityCommentDTO communityCommentDTO);

    // 댓글 삭제
    public void deleteComment(Long communityCommentId);
}
