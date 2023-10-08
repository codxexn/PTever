package com.app.ptever.mapper;


import com.app.ptever.domain.vo.UserProfileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper {

    // 유저 id로 프로필사진 경로 가져오기
    public UserProfileVO selectByUserId(Long userId);
}
