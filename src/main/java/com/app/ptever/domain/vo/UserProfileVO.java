package com.app.ptever.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class UserProfileVO implements Serializable {
    // 유저 프로필 id
    private Integer userProfileId;
    // 유저 프로필명
    private String userProfileName;
    // 유저 프로필 경로
//    private LocalDate
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===========================
    private Integer userId; // 유저 id
}
