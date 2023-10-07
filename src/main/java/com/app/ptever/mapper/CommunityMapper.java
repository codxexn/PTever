package com.app.ptever.mapper;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommunityMapper {

    // 전체게시판에서 전체 게시물 최신순으로 조회
    public List<PostDTO> selectAll(Pagination pagination);

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> selectByPostId(Long postId);

    // 개별 게시판 전체 게시물 최신순으로 조회
    public List<PostDTO> selectAllByCommunityId(Pagination pagination, Long communityId);

    // 내가 쓴 게시물 목록 조회
    public List<PostDTO> selectAllByUserId(Pagination pagination, Long userId);

    // 게시물 삭제
    public void deleteByPostId(Long postId);

    // 게시물 안의 댓글 삭제
    public void deleteCommentByPostId(Long postId);

    // 자유게시판 게시글 작성
    public void insertFreePost(PostDTO postDTO);

    // 소도구거래게시판 게시글 작성
    public void insertTransPost(PostDTO postDTO);

    // 게시물 수정
    public void updatePost(PostDTO postDTO);

    // 게시물 전체 개수 조회
    public int selectTotalAllPost();

    // 게시판 별 게시물 전체 개수 조회
    public int selectTotalByCommunityId(Long communityId);

    // 내가 쓴 게시물 전체 개수 조회
    public int selectTotalByUserId(Long userId);

}
