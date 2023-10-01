package com.app.ptever.mapper;


import com.app.ptever.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    // 로그인
    public Optional<UserVO> selectByLogin(UserVO userVO);

    // 회원가입
    public void insert(UserVO userVO);
}
