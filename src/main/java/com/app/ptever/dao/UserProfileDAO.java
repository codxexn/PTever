package com.app.ptever.dao;


import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserProfileVO;
import com.app.ptever.mapper.UserProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserProfileDAO {
    private final UserProfileMapper userProfileMapper;

    // 유저 id로 프로필사진 경로 가져오기
    public UserProfileVO readByUserId(Long userId){
        return userProfileMapper.selectByUserId(userId);
    }

    // 카카오 회원가입
    public void writeKakaoProfile(UserDTO userDTO) {
        userProfileMapper.insertKakaoProfile(userDTO);
    }

    // 카카오 프사로 프사 변경
    public void modifyProfileWithKakao(UserDTO userDTO){
        userProfileMapper.updateProfileWithKakao(userDTO);
    }
}
