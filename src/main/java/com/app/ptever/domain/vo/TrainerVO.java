package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class TrainerVO implements Serializable {
    // 트레이너 상태(default: true(트레이너 보이게), false(트레이너 삭제))
    private Boolean trainerState;
    // 트레이너 영상 개수
    private Integer trainerVideoCount;
    // 트레이너 자기소개
    private String trainerSelfIntroduce;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===========================
    private Integer userId; // 유저 id
}
