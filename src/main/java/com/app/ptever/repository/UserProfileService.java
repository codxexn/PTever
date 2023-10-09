package com.app.ptever.repository;


import com.app.ptever.domain.vo.UserProfileVO;

public interface UserProfileService {
    // 유저 id로 프로필사진 경로 가져오기
    public UserProfileVO findByUserId(Long userId);
}
