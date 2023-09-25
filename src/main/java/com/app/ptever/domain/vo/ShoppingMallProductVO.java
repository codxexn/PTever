package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class ShoppingMallProductVO implements Serializable {
    // 상품 id
    private Integer productId;
    // 상품명
    private String productTitle;
    // 상품 설명
    private String productDescription;
    // 상품 가격
    private Integer productPrice;
    // 상품 등록 일자
    private LocalDate productDate;
    // 상품 평균 별점
    private Integer productAvgScore;
    // 상품 할인율
    private Integer productDiscount;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ================================
    private Integer categoryAId; // 카테고리A id 카테고리B가 A의 PK를 식별자로 받아서 A id를 받게 됨(수정해야 될지도)
}
