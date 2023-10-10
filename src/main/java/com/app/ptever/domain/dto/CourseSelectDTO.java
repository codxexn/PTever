package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class CourseSelectDTO {
    // 강의 id
    private Long courseId;
    // 강의명
    private String courseTitle;
    // 강의 가격
    private Integer coursePrice;
    // 강의 상태(default: active, 반대: inactive(강의 삭제(?) 사라지게)
    private String courseState;
    // 강의 평균 별점
    private Double courseAvgScore;
    // 강의 난이도(쉬움, 보통, 어려움으로 분류 우리 페이지에 있나? 근데?)
    private String courseLevelDifficulty;
    // 강의 할인율
    private Integer courseDiscount;
    // 강의 생성 일자
    private LocalDateTime courseCreateDate;
    // 강의 이미지 경로
    private String courseImgPath;
    // 후기 개수
    private Integer reviewCount;
    private Long userId; // 유저 id

}
