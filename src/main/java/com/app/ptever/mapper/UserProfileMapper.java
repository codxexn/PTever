package com.app.ptever.mapper;


import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserProfileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper {

    // 유저 id로 프로필사진 경로 가져오기
    public UserProfileVO selectByUserId(Long userId);

    // 카카오 회원가입
    public void insertKakaoProfile(UserDTO userDTO);

    // 카카오 프사로 프사 변경
    public void updateProfileWithKakao(UserDTO userDTO);
}
