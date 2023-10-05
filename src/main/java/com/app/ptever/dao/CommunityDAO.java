package com.app.ptever.dao;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;
import com.app.ptever.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CommunityDAO {
    private final CommunityMapper communityMapper;

    // 전체 게시판에서 게시물 최신순으로 가져오기
    public List<PostDTO> readAll(){
        return communityMapper.selectAll();
    }

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> readByPostId(Long postId) {
        return communityMapper.selectByPostId(postId);
    }

    // 개별 게시판 전체 게시물 최신순으로 가져오기
    public List<PostDTO> readAllByCommunityId(Long communityId) {
        return communityMapper.selectAllByCommunityId(communityId);
    }

    // 내가 쓴 게시물 목록 조회
    public List<PostDTO> readAllByUserId(Long userId){
        return communityMapper.selectAllByUserId(userId);
    }

    // 게시물 삭제
    public void removeByPostId(Long postId) {
        communityMapper.deleteByPostId(postId);
    }

    // 게시물 안의 댓글 삭제
    public void removeCommentByPostId(Long postId) {
        communityMapper.deleteCommentByPostId(postId);
    }
}
