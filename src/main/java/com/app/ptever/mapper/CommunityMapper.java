package com.app.ptever.mapper;


import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {
    public List<PostDTO> selectAll();
}
