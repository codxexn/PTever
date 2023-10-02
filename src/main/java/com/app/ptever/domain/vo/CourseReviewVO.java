package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CourseReviewVO implements Serializable {
    // 강의 후기 id
    private Long courseReviewId;
    // 후기 내용
    private String reviewContent;
    // 후기 작성일
    private LocalDate reviewDate;
    // 후기 수정일
    private LocalDate reviewUpdateDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ========================
    private Long courseId; // 강의 id
}
