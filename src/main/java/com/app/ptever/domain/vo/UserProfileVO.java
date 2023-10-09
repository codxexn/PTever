package com.app.ptever.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class UserProfileVO implements Serializable {
    // 유저 프로필 id
    private Long userProfileId;
    // 유저 프로필명
    private String userProfileName;
    // 유저 프로필 경로
    private String userProfilePath;
    // 생성 날짜
    private LocalDateTime createDate;
    // 업데이트 날짜
    private LocalDateTime updateDate;
    // ===========================
    private Long userId; // 유저 id
}
