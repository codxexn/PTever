package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewDTO {
    // 강의 후기 id
    private Long courseReviewId;
    // 후기 내용
    private String reviewContent;
    // 유저 id
    private Long userId;
    // 닉네임
    private String userNickname;
    // 이미지 경로
    private String imagePath;
    private Integer courseScore;



}
