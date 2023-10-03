package com.app.ptever.dao;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;
import com.app.ptever.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CommunityDAO {
    private final CommunityMapper communityMapper;

    // 전체 게시판에서 게시물 최신순으로 가져오기
    public List<PostDTO> readAll(){
        return communityMapper.selectAll();
    }
}
