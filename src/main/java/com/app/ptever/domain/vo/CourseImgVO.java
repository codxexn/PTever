package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CourseImgVO implements Serializable {
    // 강의 이미지 id
    private Long courseImgId;
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
    // 이미지 경로
    private String imagePath;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ========================
    private Long courseId; // 강의 id
}
