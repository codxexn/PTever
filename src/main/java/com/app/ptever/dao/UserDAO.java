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

    // 회원가입
    public void write(UserVO userVO){
        userMapper.insert(userVO);
    }

    // 비밀번호 찾기를 위한 이메일주소 확인
    public Optional<UserVO> findByEmail(String userEmail) {
        return userMapper.selectByEmail(userEmail);
    }

    // 회원탈퇴
    public void modifyUserState(UserVO userVO){
        userMapper.updateToWithdraw(userVO);
    }

    // 탈퇴회원 재가입
    public void reWrite(UserVO userVO) {
        userMapper.rejoin(userVO);
    }

    // 비밀번호 재설정을 위한 임시비밀번호로의 업데이트
    public void changePassword(String userEmail, String userPassword){ userMapper.updatePassword(userEmail, userPassword);}
}
