package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class ProductViewDTO {
    // ================= 상품 테이블 속성
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
    //===================================== 상품 뷰 속성
    // 상품 재고
    private Integer productStock;
    // ===================== 카테고리 B -> A로 식별자 받는 거니 Btitle과 a 테이블 둘 다 있어야됨
    // 카테고리A id
    private Integer categoryAId;
    // 카테고리A명
    private String categoryATitle;
    // 카테고리B명
    private String categoryBTitle;
}
