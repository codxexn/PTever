package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class ProductOrderVO implements Serializable {
    // 상품 주문 id
    private Integer productOrderId;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ====================================
    private Integer courseId; // 강의 id
    private Integer orderId; // 주문 id
    private LocalDate orderDate; // 주문 날짜
    private Integer productId; // 상품 id
}
