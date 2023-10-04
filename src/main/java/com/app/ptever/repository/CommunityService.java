package com.app.ptever.repository;

import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;

import java.util.List;

public interface CommunityService {
    // 전체게시판에서 게시물 최신순으로 가져오기
    public List<PostDTO> findAll();
}
