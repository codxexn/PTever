package com.app.ptever.repository;


import com.app.ptever.domain.dto.CommunityCommentDTO;

import java.util.List;

public interface CommunityCommentService {
    // 각 게시물 별 댓글 가져오기
    public List<CommunityCommentDTO> findAllByPostId(Long postId);

    // 댓글 달기
    public void saveComment(CommunityCommentDTO communityCommentDTO);
}
