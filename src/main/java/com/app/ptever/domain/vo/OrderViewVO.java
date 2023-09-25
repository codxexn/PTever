package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class OrderViewVO implements Serializable {
    // 주문 총액
    private Integer orderTotalPrice;
    //주문 수량
    private Integer orderCount;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;

    //==============================
    private Integer orderId; //주문 id
    private LocalDate orderDate; //주문 날짜
}
