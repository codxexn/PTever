package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class OrderDTO {
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
