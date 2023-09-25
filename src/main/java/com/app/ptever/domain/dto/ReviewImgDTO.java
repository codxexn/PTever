package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class ReviewImgDTO {
    // ================ 이미지 테이블 속성

    // 이미지 파일 id
    private Integer fileId;
    // 원본 파일 이름
    private String originFileName;
    // 서버에 저장된 파일 이름
    private String storedFileName;
    // 썸네일
    private String storedThumbnail;
    // 파일 크기
    private Integer fileSize;
    // 파일 생성 날짜
    private LocalDate createFileDate;
    // 파일 삭제 여부(default: false(삭제 x), true(삭제 됨))
    private Boolean fileDeleteCheck;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ==================================== 리뷰 테이블 속성

    // 후기 id
    private Integer reviewId;
    // 후기 내용
    private String reviewContent;
    // 후기 작성일
    private LocalDate reviewDate;
    // 후기 수정일
    private LocalDate reviewUpdateDate;
    // =================================== 유저 테이블
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
