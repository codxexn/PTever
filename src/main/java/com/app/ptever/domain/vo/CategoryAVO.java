package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CategoryAVO implements Serializable {
    // 카테고리A id
    private Integer categoryAId;
    // 카테고리명
    private String categoryTitle;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
}
