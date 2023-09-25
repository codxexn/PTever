package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class PaymentVO implements Serializable {
    // 결제 ID
    private Integer paymentId;
    // 결제 방식
    private String paymentWay;
    // 결제 날짜
    private LocalDate paymentDate;
    // 결제 금액
    private Integer paymentPrice;
    // 결제 상태(결제 전, 결제 완료, 결제 실패)
    // default: 0(결제 전)/ 1(결제 완료), 2(결제 실패)
    private Integer paymentState;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;

    // ==============================================
    private Integer orderId; // 주문테이블의 주문 id
    private Integer orderDate; // 주문테이블의 주문 날짜
}
