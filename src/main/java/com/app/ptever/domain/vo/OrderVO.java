package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class OrderVO implements Serializable {
    // 주문 id
    private Integer orderId;
    // 주문 날짜
    private LocalDate orderDate;
    // 주문 상태(주문 전, 주문 완료, 주문 실패)
    // default: 0(주문 전) / 1(주문 완료), 2(주문 실패)
    private Integer orderState;
    // 쿠폰 번호
    private String couponNum;
    // 취소 날짜
    private LocalDate canceledDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===============================================
    private Integer userId; // 유저테이블 유저 id
}
