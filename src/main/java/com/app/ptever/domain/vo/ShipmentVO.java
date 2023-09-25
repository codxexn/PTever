package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class ShipmentVO implements Serializable {
    // 배송 id
    private Integer shipmentId;
    // 배송지
    private String shipmentAddress;
    // 배송 날짜
    private LocalDate shipmentDate;
    // 배송 상태(배송 전, 배송 중, 배송 완료)
    // default: 0(배송 전)/ 1(배송 중), 2(배송 완료)
    private Integer shipmentState;
    // 수령자 이름
    private String receiverName;
    // 수령자 전화번호
    private String receiverPhoneNum;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;

    // ==================================
    private Integer paymentId; // 결제테이블 결제 id
}
