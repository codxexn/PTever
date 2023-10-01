package com.app.ptever.repository;

import com.app.ptever.domain.vo.UserVO;

import java.util.Optional;

public interface UserService {
    
    // 로그인
    public Optional<UserVO> login(UserVO userVO);

    // 회원가입
    public void save(UserVO userVO);
}
