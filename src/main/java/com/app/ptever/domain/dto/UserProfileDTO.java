package com.app.ptever.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class UserProfileDTO {
    // 유저 프로필 id
    private Integer userProfileId;
    // 유저 프로필명
    private String userProfileName;
    // 유저 프로필 경로
//    private LocalDate
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===========================
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
