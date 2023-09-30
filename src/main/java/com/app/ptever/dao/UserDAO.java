package com.app.ptever.dao;


import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    // 로그인
    public Optional<UserVO> login(UserVO userVO) {
        return userMapper.selectByLogin(userVO);
    }
}
