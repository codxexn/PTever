package com.app.ptever.repository;


import com.app.ptever.domain.vo.CommunityCommentDTO;
import com.app.ptever.domain.vo.CommunityCommentVO;

import java.util.List;

public interface CommunityCommentService {
    // 각 게시물 별 댓글 가져오기
    public List<CommunityCommentDTO> findAllByPostId(Long postId);
}
