package com.app.ptever.repository;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.PostVO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CommunityService {
    // 전체게시판에서 게시물 최신순으로 가져오기
    public List<PostDTO> findAll(Pagination pagination);

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> findByPostId(Long postId);

    // 개별 게시판 전체 게시물 최신순으로 가져오기
    public List<PostDTO> findAllByCommunityId(Pagination pagination, Long communityId);

    // 내가 쓴 게시물 목록 조회
    public List<PostDTO> findAllByUserId(Pagination pagination, Long userId);

    // 게시물 삭제
    public void discardByPostId(Long postId);

    // 게시물 안의 댓글 삭제
    public void discardCommentByPostId(Long postId);

    // 자유게시판 게시물 작성
    public void saveFreePost(PostDTO postDTO);

    // 소도구 거래 게시판 게시물 작성
    public void saveTransPost(PostDTO postDTO);

    // 게시물 수정
    public void revisePost(PostDTO postDTO);

    // 게시물 전체 개수 조회
    public int findAllPostCounts();

    // 게시판 별 게시물 전체 개수 조회
    public int findTotalByCommunityId(Long communityId);

    // 내가 쓴 게시물 전체 개수 조회
    public int findTotalByUserId(Long userId);
}
