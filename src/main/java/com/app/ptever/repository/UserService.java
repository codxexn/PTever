package com.app.ptever.repository;

import com.app.ptever.domain.vo.UserVO;
import org.apache.catalina.User;

import java.util.Optional;

public interface UserService {
    
    // 로그인
    public Optional<UserVO> login(UserVO userVO);

    // 회원가입
    public void save(UserVO userVO);

    // 비밀번호 찾기를 위한 이메일주소 확인
    public Optional<UserVO> checkByEmail(String userEmail);

    // 회원탈퇴
    public void deactivateUser(UserVO userVO);

    // 탈퇴 회원 재가입
    public void resave(UserVO userVO);
}
