package com.app.ptever.mapper;


import com.app.ptever.domain.vo.CommunityCommentDTO;
import com.app.ptever.domain.vo.CommunityCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityCommentMapper {
    // 각 게시물 별 댓글 가져오기
    public List<CommunityCommentDTO> selectAllByPostId(Long postId);
}
