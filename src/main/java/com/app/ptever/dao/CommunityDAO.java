package com.app.ptever.dao;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.pagination.Pagination;
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
    public List<PostDTO> readAll(Pagination pagination){
        return communityMapper.selectAll(pagination);
    }

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> readByPostId(Long postId) {
        return communityMapper.selectByPostId(postId);
    }

    // 개별 게시판 전체 게시물 최신순으로 가져오기
    public List<PostDTO> readAllByCommunityId(Pagination pagination, Long communityId) {
        return communityMapper.selectAllByCommunityId(pagination, communityId);
    }

    // 내가 쓴 게시물 목록 조회
    public List<PostDTO> readAllByUserId(Pagination pagination, Long userId){
        return communityMapper.selectAllByUserId(pagination, userId);
    }

    // 게시물 삭제
    public void removeByPostId(Long postId) {
        communityMapper.deleteByPostId(postId);
    }

    // 게시물 안의 댓글 삭제
    public void removeCommentByPostId(Long postId) {
        communityMapper.deleteCommentByPostId(postId);
    }

    // 자유게시판 게시물 작성
    public void writeFreePost(PostDTO postDTO) {
        communityMapper.insertFreePost(postDTO);
    }

    // 소도구거래게시판 게시물 작성
    public void writeTransPost(PostDTO postDTO) {
        communityMapper.insertTransPost(postDTO);
    }

    // 게시물 수정
    public void modifyPost(PostDTO postDTO) {
        communityMapper.updatePost(postDTO);
    }

    // 게시물 전체 개수 조회
    public int readAllPostCounts() {
        return communityMapper.selectTotalAllPost();
    }

    // 게시판 별 게시물 전체 개수 조회
    public int readTotalByCommunityId(Long communityId) {
        return communityMapper.selectTotalByCommunityId(communityId);
    }

    // 내가 쓴 게시물 개수 전체 조회
    public int readTotalByUserId(Long userId){
        return communityMapper.selectTotalByUserId(userId);
    }

    // 유저id로 가장 최신 게시물 찾기
    public PostVO readPostByUserId(Long userId){
        return communityMapper.selectPostByUserId(userId);
    }

    // 게시물 안의 이미지 삭제
    public void removeImageByPostId(Long postId){
        communityMapper.deleteImageByPostId(postId);
    }
}
