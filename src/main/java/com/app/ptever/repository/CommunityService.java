package com.app.ptever.repository;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CommunityService {
    // 전체게시판에서 게시물 최신순으로 가져오기
    public List<PostDTO> findAll();

    // 게시물(1개) 상세 조회
    public Optional<PostDTO> findByPostId(Long postId);
}
