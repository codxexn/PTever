package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class ProductCartVO implements Serializable {
    // 장바구니 id
    private Integer cartId;
    // 상품 수량
    private Integer productCount;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ================================
    private Integer productId; // 상품 id
}
