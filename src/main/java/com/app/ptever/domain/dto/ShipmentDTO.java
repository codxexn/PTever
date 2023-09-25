package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class ShipmentDTO {
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

    // ================================== 결제 테이블 속성
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
    // ================================== 주문 테이블
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
    // ============================== 유저 테이블
    // 유저 id
    private Integer userId;
    // 사용자 이메일
    private String userEmail;
    // 비밀번호
    private String userPassword;
    // 사용자 이름
    private String userName;
    // 사용자 유형(false: 일반 회원, true: 트레이너 회원)
    // default: false(일반 회원)
    private Boolean userType;
    // 사용자 상태(false: 회원, true: 탈퇴 회원)
    private Boolean userState;
    // 생년월일
    private LocalDate userBirth;
    // 휴대전화
    private String userPhoneNum;
    // 닉네임
    private String userNickName;
    // 성별( false: Male, true: female)
    // default: false
    private Boolean userGender;
    // 사용자 로그인 코드(default: normal(일반 회원), 카카오 회원) 비교
    private String userLoginCode;

}
