package com.app.ptever.mapper;


import com.app.ptever.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.text.html.Option;
import java.util.Optional;

@Mapper
public interface UserMapper {

    // 로그인
    public Optional<UserVO> selectByLogin(UserVO userVO);

    // 회원가입
    public void insert(UserVO userVO);

    // 비밀번호 찾기를 위한 이메일주소 확인
    public Optional<UserVO> selectByEmail(String userEmail);

    // 회원 탈퇴
    public void updateToWithdraw(UserVO userVO);

    // 탈퇴회원 재가입(update)
    public void rejoin(UserVO userVO);

    // 비밀번호 재설정을 위한 임시비밀번호로의 업데이트
    public void updatePassword(String userEmail, String userPassword);
}
