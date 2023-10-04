package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CourseDTO implements Serializable {
    // ============================= 강의 테이블 속성
    // 강의 id
    private Long courseId;
    // 강의명
    private String courseTitle;
    // 강의 설명
    private String courseDescription;
    // 강의 가격
    private Integer coursePrice;
    // 강의 평균 별정
    private Integer courseAvgScore;
    // 강의 난이도(쉬움, 보통, 어려움으로 분류 우리 페이지에 있나? 근데?)
    private String courseLevelDifficult;
    // 강의 상태(default: true(강의 보이게), false(강의 삭제(?) 사라지게)
    private Boolean courseState;
    // 강의 생성 일자
    private LocalDate courseDate;
    // 강의 할인율
    private Integer courseDiscount;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;

    // ============================ 유저 테이블

    // 유저 id
    private Long userId;
    // 사용자 이메일
    private String userEmail;
    // 비밀번호
    private String userPassword;
    // 사용자 이름
    private String userName;
    // 사용자 유형(false: 일반 회원, true: 트레이너 회원)
    // default: false(일반 회원)
    private String userType;
    // 사용자 상태(false: 회원, true: 탈퇴 회원)
    private String userState;
    // 생년월일
    private LocalDate userBirth;
    // 휴대전화
    private String userPhoneNum;
    // 닉네임
    private String userNickName;
    // 성별( false: Male, true: female)
    // default: false
    private String userGender;
    // 사용자 로그인 코드(default: normal(일반 회원), 카카오 회원) 비교
    private String userLoginCode;
    //================================== 카테고리B 테이블 속성 fk 식별자로 카테고리A를 받음
    // 카테고리B 제목
    private String categoryBTitle;
    // 카테고리A id
    private Integer categoryAId;
    // 카테고리A 제목
    private String categoryTitle;
    // ============================ 강의후기 테이블
    // 강의 후기 id
    private Long courseReviewId;
    // 후기 내용
    private String reviewContent;
    // 후기 작성일
    private LocalDate reviewDate;
    // 후기 수정일
    private LocalDate reviewUpdateDate;

}
