package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class UserVO implements Serializable {
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
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
}
