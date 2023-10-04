package com.app.ptever.dao;


import com.app.ptever.domain.dto.CommunityCommentDTO;
import com.app.ptever.mapper.CommunityCommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CommunityCommentDAO {
    private final CommunityCommentMapper communityCommentMapper;

    // 각 게시물 별 댓글 가져오기
    public List<CommunityCommentDTO> readAllByPostId(Long postId){
        return communityCommentMapper.selectAllByPostId(postId);
    }

    // 댓글 달기
    public void writeComment(CommunityCommentDTO communityCommentDTO){
        communityCommentMapper.insertComment(communityCommentDTO);
    }
}
