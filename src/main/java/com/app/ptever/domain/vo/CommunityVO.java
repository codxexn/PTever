package com.app.ptever.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CommunityVO implements Serializable {
    // 커뮤니티 id
    private Long communityId;
    // 커뮤니티 종류
    private String communityType;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
//    // ============================
//    private Long userId; // 유저 id
}
