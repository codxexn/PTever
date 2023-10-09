package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Data
public class ShoppingMallSelectDTO {
    private Integer productId;
    // 상품명
    private String productTitle;
    // 상품 설명
    private String productDescription;
    // 상품 가격
    private Integer productPrice;
    // 상품 평균 별점
    private Double productAvgScore;
    // 상품 할인율
    private Integer productDiscount;

    //상품 등록 일
    private LocalDateTime productRegisterDate;

    // 상품 이미지 경로
    private String productImgPath;
}
