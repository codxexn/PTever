package com.app.ptever.repository;


import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserProfileVO;

public interface UserProfileService {
    // 유저 id로 프로필사진 경로 가져오기
    public UserProfileVO findByUserId(Long userId);

    // 카카오 회원가입
    public void saveKakaoProfile(UserDTO userDTO);

    // 카카오 프사로 프사 변경
    public void reviseProfileWithKakao(UserDTO userDTO);
}
