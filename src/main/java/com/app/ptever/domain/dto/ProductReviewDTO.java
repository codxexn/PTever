package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class ProductReviewDTO {
    // ======================== 상품 테이블 속성

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

    // =========================== 후기 테이블 속성
    // 후기 id
    private Integer reviewId;
    // 후기 내용
    private String reviewContent;
    // 후기 작성일
    private LocalDate reviewDate;
    // 후기 수정일
    private LocalDate reviewUpdateDate;
    // =========================== 유저 테이블
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

    // ===================== 카테고리 B -> A로 식별자 받는 거니 Btitle과 a 테이블 둘 다 있어야됨
    // 카테고리A id
    private Integer categoryAId;
    // 카테고리A명
    private String categoryATitle;
    // 카테고리B명
    private String categoryBTitle;

}
