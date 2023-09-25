package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CourseVO implements Serializable {
    // 강의 id
    private Integer courseId;
    // 강의명
    private String courseTitle;
    // 강의 설명
    private String courseDescription;
    // 강의 가격
    private Integer coursePrice;
    // 강의 평균 별정
    private Integer courseAvgScore;
    // 강의 난이도(쉬움, 보통, 어려움으로 분류 우리 페이지에 있나? 근데?)
    private String courseLevelDifficult;
    // 강의 상태(default: true(강의 보이게), false(강의 삭제(?) 사라지게)
    private Boolean courseState;
    // 강의 생성 일자
    private LocalDate courseDate;
    // 강의 할인율
    private Integer courseDiscount;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ============================
    private Integer userId; // 유저 id
    private Integer categoryAId; // 카테고리A id 카테고리B가 A의 PK를 식별자로 받아서 A id를 받게 됨(수정해야 될지도)
}
