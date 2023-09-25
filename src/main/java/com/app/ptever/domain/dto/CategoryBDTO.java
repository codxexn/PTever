package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class CategoryBDTO {
    // 카테고리명
    private String categoryBTitle;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // =================================
    // 카테고리A id
    private Integer categoryAId;
    // 카테고리명
    private String categoryATitle;
}
